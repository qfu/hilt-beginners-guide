package com.github.mrbean355.android.hilt.multibindings

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MultiBindingsModule {

}

class Game(val name: String)