package com.github.mrbean355.android.hilt.lazy

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LazyModule {
    private var nextNumber = 1L

    @Provides
    fun provideCar(): Car = Car("Mazda ${nextNumber++}")

}

class Car(val make: String)