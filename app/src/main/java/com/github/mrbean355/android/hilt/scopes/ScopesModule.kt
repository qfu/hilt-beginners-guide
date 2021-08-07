package com.github.mrbean355.android.hilt.scopes

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ScopesModule {

    // This binding is "unscoped".
    // A new instance is created each time it is injected.
    @Provides
    fun provideOreo(): Oreo = Oreo()

    // This binding is a singleton.
    // One instance is reused throughout the whole app's lifespan.
    @Provides
    @Singleton
    fun provideJetpack(): Jetpack = Jetpack()

}

@Module
@InstallIn(ActivityComponent::class)
object ActivityScopesModule {

    // This binding is scoped to the activity instance.
    // One instance is reused throughout the activity's lifespan.
    // Each activity instance gets its own Pie instance.
    @Provides
    @ActivityScoped
    fun providePie(): Pie = Pie()

}

class Oreo {
    val number = next++

    companion object {
        private var next = 1L
    }
}

class Pie {
    val number = next++

    companion object {
        private var next = 1L
    }
}

class Jetpack {
    val number = next++

    companion object {
        private var next = 1L
    }
}