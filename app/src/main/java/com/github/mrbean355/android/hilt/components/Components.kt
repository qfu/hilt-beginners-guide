package com.github.mrbean355.android.hilt.components

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

class Coffee

class Tea

class HotChocolate