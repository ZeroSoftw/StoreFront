package com.mx.farmaluxa.sharedutil.core.util.ui

import android.os.SystemClock
import android.view.View

/**
 * SafeClickListener
 * https://medium.com/@simonkarmy2004/solving-android-multiple-clicks-problem-kotlin-b99c06135da0
 */
class SafeClickListener(
    private var defaultInterval: Int = 1000,
    private val onSafeCLick: (View) -> Unit
) : View.OnClickListener {

    private var lastTimeClicked: Long = 0

    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - this.lastTimeClicked < this.defaultInterval) {
            return
        }

        this.lastTimeClicked = SystemClock.elapsedRealtime()

        this.onSafeCLick(v)
    }
}