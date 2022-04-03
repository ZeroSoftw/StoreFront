package com.mx.farmaluxa.sharedutil.core.util

class SUURL {
    companion object{
        fun getBaseURL(): String {
            var url = "http://"
            url += "74.208.233.250/"
            url += "Luxaproyect-0.0.1-SNAPSHOT/"
//            url += if (BuildConfig.PORT_POS == "") "/" else ":${BuildConfig.PORT_POS}/"

            return url
        }

        val login
            get() = "login"
    }
}