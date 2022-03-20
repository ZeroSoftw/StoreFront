package com.mx.farmaluxa.warehouse.data.model.entity

data class RequisitionEntity(
    var requisitionId: String,
    var nameClient: String,
    var requestDate: String,
    var intStatus: Int,
    var totalProducts: Int
)