@file:Suppress("unused")

package com.github.mrbean355.android.hilt.components

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment

open class SingletonComponent(
    val application: Application
) {

    fun provideAppMonitor(application: Application): AppMonitor = AppMonitor(application)

}

open class ActivityRetainedComponent(
    application: Application
) : SingletonComponent(application)

open class ActivityComponent(
    val activity: Activity,
    application: Application
) : ActivityRetainedComponent(application) {

    fun provideActivityMonitor(): ActivityMonitor = ActivityMonitor(activity)

}

open class FragmentComponent(
    val fragment: Fragment,
    activity: Activity,
    application: Application
) : ActivityComponent(activity, application)