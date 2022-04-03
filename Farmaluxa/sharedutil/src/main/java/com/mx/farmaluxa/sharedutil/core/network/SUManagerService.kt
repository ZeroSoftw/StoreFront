package com.mx.farmaluxa.sharedutil.core.network

import android.content.Context
import com.google.gson.Gson
import com.mx.farmaluxa.sharedutil.R
import com.mx.farmaluxa.sharedutil.data.model.entity.SUErrorEntity
import com.mx.farmaluxa.sharedutil.data.model.entity.SUGenericEntity
import org.json.JSONObject
import retrofit2.Response
import java.io.Serializable
import java.net.HttpURLConnection

class SUManagerService {

    companion object {

        fun validateErrorMessage(code: String, context: Context): Pair<String?, Boolean> {
            val errorMessage: String
            val navigation: Boolean

            when (code) {
                "PM-0000" -> {
                    errorMessage = context.getString(R.string.PM_0000)
                    navigation = false
                }
                else -> {
                    errorMessage = context.getString(R.string.PM_0001)
                    navigation = true
                }
            }

            return Pair(errorMessage, navigation)
        }

        private fun errorServiceHandle(context: Context, entity: SUErrorEntity): String {
            val errorMessage: String

            when {
                entity.message.contains("Time out") -> {
                    errorMessage = this.errorDescription(context, ErrorServicesEnum.ErrorTimeOut)
                }
                entity.message.contains("failed to connect") -> {
                    errorMessage = this.errorDescription(
                        context,
                        ErrorServicesEnum.ErrorNotConnectedToInternet
                    )
                }
                entity.message.contains("unknown") -> {
                    errorMessage = this.errorDescription(context, ErrorServicesEnum.ErrorUnknown)
                }
                else -> {
                    when (entity.status) {
                        HttpURLConnection.HTTP_BAD_REQUEST -> {
                            errorMessage = this.errorDescription(
                                context,
                                ErrorServicesEnum.ErrorCommunications
                            )
                        }
                        HttpURLConnection.HTTP_NOT_FOUND -> {
                            errorMessage = this.errorDescription(
                                context,
                                ErrorServicesEnum.ErrorCommunications
                            )
                        }
                        HttpURLConnection.HTTP_INTERNAL_ERROR -> {
                            errorMessage = this.errorDescription(
                                context,
                                ErrorServicesEnum.ErrorCommunications
                            )
                        }
                        HttpURLConnection.HTTP_CLIENT_TIMEOUT -> {
                            errorMessage =
                                this.errorDescription(context, ErrorServicesEnum.ErrorTimeOut)
                        }
                        HttpURLConnection.HTTP_GATEWAY_TIMEOUT -> {
                            errorMessage =
                                this.errorDescription(context, ErrorServicesEnum.ErrorTimeOut)
                        }
                        else -> {
                            errorMessage = this.errorDescription(
                                context,
                                ErrorServicesEnum.ErrorCommunications
                            )
                        }
                    }
                }
            }

            return errorMessage
        }

        private fun errorDescription(
            context: Context,
            enum: ErrorServicesEnum,
            reason: Int = 0
        ): String {
            when (enum) {
                ErrorServicesEnum.NullResponseError -> {
                    return context.getString(R.string.service_error_null_response)
                }
                ErrorServicesEnum.NoDataError -> {
                    return context.getString(R.string.service_error_not_data)
                }
                ErrorServicesEnum.ErrorUnknown -> {
                    return context.getString(R.string.service_error_unknown)
                }
                ErrorServicesEnum.ErrorForReason -> {
                    return context.getString(reason)
                }
                ErrorServicesEnum.ErrorGetDeviceID -> {
                    return context.getString(R.string.service_error_get_device_id)
                }
                ErrorServicesEnum.InvalidateSession -> {
                    return context.getString(R.string.service_error_invalidate_session)
                }
                ErrorServicesEnum.ErrorTimeOut -> {
                    return context.getString(R.string.service_error_time_out)
                }
                ErrorServicesEnum.ErrorNotConnectedToInternet -> {
                    return context.getString(R.string.service_error_not_connected)
                }
                ErrorServicesEnum.ErrorCommunications -> {
                    return context.getString(R.string.service_error_communications)
                }
                ErrorServicesEnum.ErrorCorruptedData -> {
                    return context.getString(R.string.service_error_communications)
                }
            }
        }

        fun <T> onFailure(message: String, context: Context): SUGenericEntity<T> {
            val errorEntity = SUErrorEntity()
            errorEntity.message = message
            return SUGenericEntity(message = this.errorServiceHandle(context, errorEntity))
        }

        inline fun <reified T> onSuccess(
            response: Response<Any>,
            context: Context
        ): SUGenericEntity<T> {

            var entity: T? = null
            var message = ""
            var code = ""
            var navigation = false

            try {
                val jsonObject = if (response.body() != null) {
                    JSONObject(Gson().toJson(response.body()))
                } else {
                    JSONObject(response.errorBody()!!.charStream().readText())
                }

                var map: Map<String, Any> = HashMap()
                map = Gson().fromJson(jsonObject.toString(), map.javaClass)
                val a = map
//                val codeJson = map.filter { it.key.contains("cod", true) }.map { it.key }.first()
//                val messageJson =
//                    map.filter { it.key.contains("mens", true) }.map { it.key }.first()
//                code = jsonObject.getString(codeJson)
//                message = jsonObject.getString(messageJson)
//
//                if (response.isSuccessful && code == "PM-0000") {
//                    entity = Gson().fromJson(jsonObject.toString(), T::class.java)
//                }
//
//                if (code != "PM-WS17" && !code.contains("0000")) {
//                    val pair = validateErrorMessage(code, context)
//                    message = pair.first!!
//                    navigation = pair.second
//                }

            } catch (ex: Exception) {
                val pair = validateErrorMessage(code, context)
                message = pair.first!!
                navigation = pair.second
            }

            return SUGenericEntity(
                entity = entity,
                message = message,
                navigation = navigation
            )
        }
    }

    enum class ErrorServicesEnum : Serializable {
        NullResponseError,
        NoDataError,
        ErrorUnknown,
        ErrorForReason,
        ErrorGetDeviceID,
        InvalidateSession,
        ErrorTimeOut,
        ErrorNotConnectedToInternet,
        ErrorCommunications,
        ErrorCorruptedData
    }

}