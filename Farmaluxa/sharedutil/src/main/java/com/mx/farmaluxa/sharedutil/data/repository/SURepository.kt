package com.mx.farmaluxa.sharedutil.data.repository

import android.content.Context
import com.mx.farmaluxa.sharedutil.core.network.*
import com.mx.farmaluxa.sharedutil.data.model.entity.SUGenericEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SURepository {

    suspend inline fun <reified T> apiRepository(
        context: Context,
        url: String,
        entityRequest: Any? = null,
    ): SUGenericEntity<T> {

        return withContext(Dispatchers.IO) {

            try {
                val retrofitRepository = SURetrofit.retrofitHelper().create(SUService::class.java)

                val response = if (entityRequest == null) {
                    retrofitRepository.getServiceCoroutine(url)
                } else {
                    retrofitRepository.postServiceCoroutine(url, entityRequest)
                }

                SUManagerService.onSuccess(response, context)

            } catch (t: Throwable) {
                SUManagerService.onFailure(t.message!!, context)
            }
        }
    }

}