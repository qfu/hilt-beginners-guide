package com.github.mrbean355.android.hilt.components

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    // The application context can be injected anywhere in the app.
    @Provides
    fun provideAppMonitor(application: Application): AppMonitor = AppMonitor(application)

}

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    // The activity instance can be injected into the activity component,
    // and into components that extend from the activity component.
    @Provides
    fun provideActivityMonitor(activity: Activity): ActivityMonitor = ActivityMonitor(activity)

}

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    // The fragment instance can be injected into the fragment component,
    // and into components that extend from the fragment component.
    @Provides
    fun provideFragmentMonitor(fragment: Fragment): FragmentMonitor = FragmentMonitor(fragment)

}

class AppMonitor(val application: Application)

class ActivityMonitor(val activity: Activity)

class FragmentMonitor(val fragment: Fragment)