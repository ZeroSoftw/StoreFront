package com.mx.farmaluxa.sharedutil.data.repository

import android.content.Context
import com.mx.farmaluxa.sharedutil.core.network.SURetrofit.retrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class SURepository {

    /*suspend inline fun <reified T> apiRepository(
        context: Context,
        url: String,
        entityRequest: Any? = null,
    ): POSGenericResponse<T> {

        return withContext(Dispatchers.IO){

            try {
                val retrofitRepository = Retrofit.retrofitHelper()?.create(POSService::class.java)

                val response = if (entityRequest == null) {
                    retrofitRepository!!.getServiceCoroutine(url)
                } else {
                    retrofitRepository!!.postServiceCoroutine(url, entityRequest)
                }

                ResponseManagementServices.onSuccess(response, context)

//            ResponseManagementServices.onFailure(response.message!!, context)
            } catch (t: Throwable) {
                ResponseManagementServices.onFailure(t.message!!, context)
            }
        }
    }*/

}