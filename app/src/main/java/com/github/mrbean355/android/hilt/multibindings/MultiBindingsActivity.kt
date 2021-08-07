package com.github.mrbean355.android.hilt.multibindings

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MultiBindingsActivity : AppCompatActivity() {
    @Inject
    lateinit var dogs: Set<Dog>

    @Inject
    lateinit var games: Map<String, Game>

    // When injecting something that has a type argument of a super-class,
    // it is necessary to use @JvmSuppressWildcards or the build will fail.
    @Inject
    lateinit var commands: Set<@JvmSuppressWildcards Command>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                dogs.forEach { dog ->
                    item {
                        Text(text = dog.name)
                    }
                }
                item { Spacer(Modifier.padding(top = 8.dp)) }
                games.forEach { (key, game) ->
                    item {
                        Text(text = "$key -> ${game.name}")
                    }
                }
                item { Spacer(Modifier.padding(top = 8.dp)) }
                commands.forEach { cmd ->
                    item {
                        Text(text = cmd::class.simpleName.toString())
                    }
                }
            }
        }
    }
}