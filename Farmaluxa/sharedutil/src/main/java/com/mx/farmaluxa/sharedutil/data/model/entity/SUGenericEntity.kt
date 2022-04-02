package com.mx.farmaluxa.sharedutil.data.model.entity

data class SUGenericEntity<T>(
    var entity: T? = null,
    var message: String,
    var navigation: Boolean = false
)
