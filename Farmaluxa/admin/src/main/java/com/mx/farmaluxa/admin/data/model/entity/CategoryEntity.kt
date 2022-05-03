package com.mx.farmaluxa.admin.data.model.entity

import java.io.Serializable

class CategoryEntity(
    var categoryKey: String,
    var categoryName: String
) : Serializable {
    override fun toString(): String {
        return "CategoryEntity(categoryKey='$categoryKey', categoryName='$categoryName')"
    }
}