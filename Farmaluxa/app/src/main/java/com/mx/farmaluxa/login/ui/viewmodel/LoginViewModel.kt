package com.mx.farmaluxa.login.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mx.farmaluxa.login.data.model.request.LoginRequest
import com.mx.farmaluxa.login.data.model.response.LoginResponse
import com.mx.farmaluxa.sharedutil.data.repository.SURepository
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val repository = SURepository()
    val isLoading = MutableLiveData<Boolean>()

    var mldLogin = MutableLiveData<LoginResponse>()

    fun getLoginViewModel(context: Context, entityRequest: LoginRequest) {
        mldLogin = MutableLiveData()

        viewModelScope.launch {
            isLoading.postValue(true)

            /*mldLogin.postValue(
                repository.apiRepository<>(
                    context = context,
                    url = URLConstants.ivaFactor,
                    entityRequest = entityRequest
                )
            )*/
            isLoading.postValue(false)
        }
    }


}