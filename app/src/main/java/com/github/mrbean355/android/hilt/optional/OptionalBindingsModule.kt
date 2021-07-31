package com.github.mrbean355.android.hilt.optional

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface OptionalBindingsModule {

}

class Money(val amount: Long)