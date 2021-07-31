package com.github.mrbean355.android.hilt.nullable

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NullableBindingsModule {

}

class House(val size: Int)