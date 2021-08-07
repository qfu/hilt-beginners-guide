@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.github.mrbean355.android.hilt.components

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment

// NOTE: the code in this file is to help explain the concept of Hilt "components".
// It is just pseudo-code and should not be added to your apps.

open class SingletonComponent(
    // Default binding provided by Hilt.
    val application: Application
) {

    // Example binding that would be added via a @Module.
    fun provideAppMonitor(): AppMonitor = AppMonitor(application)

}

open class ActivityRetainedComponent(
    // Default binding provided by Hilt.
    application: Application
) : SingletonComponent(application)

open class ActivityComponent(
    // Default bindings provided by Hilt.
    val activity: Activity,
    application: Application
) : ActivityRetainedComponent(application) {

    // Example binding that would be added via a @Module.
    fun provideActivityMonitor(): ActivityMonitor = ActivityMonitor(activity)

}

open class FragmentComponent(
    // Default bindings provided by Hilt.
    val fragment: Fragment,
    activity: Activity,
    application: Application
) : ActivityComponent(activity, application) {

    // Example binding that would be added via a @Module.
    fun provideFragmentMonitor(): FragmentMonitor = FragmentMonitor(fragment)

}