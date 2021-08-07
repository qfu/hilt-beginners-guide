package com.github.mrbean355.android.hilt.qualifiers

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object QualifiersModule {

    @Provides
    @Android
    fun provideAndroidPhone(): Phone = Phone("OnePlus 5")

    @Provides
    @Ios
    fun provideIosPhone(): Phone = Phone("iPhone 12")

}

class Phone(val model: String)

@Qualifier
annotation class Android

@Qualifier
annotation class Ios