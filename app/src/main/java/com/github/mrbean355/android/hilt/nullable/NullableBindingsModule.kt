package com.github.mrbean355.android.hilt.nullable

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlin.random.Random

@Module
@InstallIn(SingletonComponent::class)
object NullableBindingsModule {

    // Return types in @Module methods can be nullable.
    // In Java, annotate with @Nullable.
    @Provides
    fun provideHouse(): House? {
        return if (Random.nextBoolean()) House(100) else null
    }
}

class House(val size: Int)