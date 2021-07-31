package com.github.mrbean355.android.hilt.qualifiers

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object QualifiersModule {

}

class Phone(val model: String)