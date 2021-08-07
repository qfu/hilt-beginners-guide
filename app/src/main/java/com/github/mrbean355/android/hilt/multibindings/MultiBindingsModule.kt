package com.github.mrbean355.android.hilt.multibindings

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
interface MultiBindingsModule {

    companion object {

        // Set multi-bindings:

        @Provides
        @IntoSet
        fun provideSpotDog(): Dog = Dog("Spot")

        @Provides
        @IntoSet
        fun provideButchDog(): Dog = Dog("Butch")

        @Provides
        @ElementsIntoSet // return multiple objects from one method.
        fun provideMultipleDogs(): Set<Dog> = setOf(
            Dog("Spike"),
            Dog("Lucky"),
        )

        // Map multi-bindings:

        @Provides
        @IntoMap
        @StringKey("dota")
        fun provideDotaGame(): Game = Game("Dota 2")

        @Provides
        @IntoMap
        @StringKey("apex")
        fun provideApexLegendsGame(): Game = Game("Apex Legends")

        @Provides
        @IntoMap
        @StringKey("minesweeper")
        fun provideMinesweeperGame(): Game = Game("Minesweeper")

    }

    // Binding multiple implementations to a single interface:
    // (also possible when using map multi-bindings)

    @Binds
    @IntoSet
    fun bindDeleteCommand(impl: DeleteCommand): Command

    @Binds
    @IntoSet
    fun bindCopyCommand(impl: CopyCommand): Command

}

class Dog(val name: String)

class Game(val name: String)

interface Command {
    fun execute(args: Array<String>)
}

class DeleteCommand @Inject constructor() : Command {

    override fun execute(args: Array<String>) {
        require(args.size == 1)
        println("Deleting ${args[0]}")
        TODO("not used in the demo app")
    }
}


class CopyCommand @Inject constructor() : Command {

    override fun execute(args: Array<String>) {
        require(args.size == 2)
        println("Copying ${args[0]} to ${args[1]}")
        TODO("not used in the demo app")
    }
}