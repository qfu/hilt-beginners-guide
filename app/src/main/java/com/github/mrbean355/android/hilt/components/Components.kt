package com.github.mrbean355.android.hilt.components

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

}

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

}

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

}

class AppMonitor(val application: Application)

class ActivityMonitor(val activity: Activity)

class FragmentMonitor(val fragment: Fragment)