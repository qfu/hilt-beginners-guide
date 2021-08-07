package com.github.mrbean355.android.hilt.optional

import dagger.BindsOptionalOf
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface OptionalBindingsModule {

    // @BindsOptionalOf methods tell Dagger to not fail when
    // the binding doesn't exist.

    @BindsOptionalOf
    fun bindsOptionalMoney(): Money

    @BindsOptionalOf
    fun bindsOptionalCreditCard(): CreditCard

    companion object {

        // This binding does not exist (it is commented out), and can't be injected.
        // @Provides
        // fun provideMoney(): Money = Money(1_000)

        // This binding does exist, and can be injected.
        @Provides
        fun provideCreditCard(): CreditCard = CreditCard(999_999)

    }
}

class Money(val amount: Long)

class CreditCard(val debt: Long)