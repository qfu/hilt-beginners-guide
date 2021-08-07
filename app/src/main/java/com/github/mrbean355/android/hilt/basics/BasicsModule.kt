package com.github.mrbean355.android.hilt.basics

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

// Dagger "modules" allow us to satisfy dependencies that will be injected.
// Dagger looks at the return type and parameters of the methods.
// Dagger does NOT care about the method names.
@Module
@InstallIn(SingletonComponent::class)
interface BasicsModule {

    // Bind the repo implementation to the interface.
    // When the interface is injected, use the specified implementation type.
    // Implementation class must have an @Inject constructor.
    @Binds
    fun bindBeerRepository(impl: BeerRepositoryImpl): BeerRepository

    companion object {

        // Concrete methods that construct a dependency.
        // Dagger will call these methods when it needs to create instances.

        @Provides
        fun provideBeerService(): BeerService = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()

        @Provides
        fun provideBeerCache(): BeerCache = BeerCache

        @Provides
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    }
}