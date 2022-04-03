package com.mx.farmaluxa.login.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mx.farmaluxa.login.data.model.request.LoginEntityRequest
import com.mx.farmaluxa.login.data.model.response.LoginEntityResponse
import com.mx.farmaluxa.sharedutil.core.util.SUURL
import com.mx.farmaluxa.sharedutil.data.model.entity.SUGenericEntity
import com.mx.farmaluxa.sharedutil.data.repository.SURepository
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val repository = SURepository()
    val isLoading = MutableLiveData<Boolean>()

    var mldLoginEntity = MutableLiveData<SUGenericEntity<LoginEntityResponse>>()

    fun getLoginViewModel(context: Context, entityEntityRequest: LoginEntityRequest) {
        mldLoginEntity = MutableLiveData()

        viewModelScope.launch {
            isLoading.postValue(true)

            mldLoginEntity.postValue(
                repository.apiRepository(
                    context = context,
                    url = SUURL.login,
                    entityRequest = entityEntityRequest
                )
            )
            isLoading.postValue(false)
        }
    }
}