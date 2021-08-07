package com.github.mrbean355.android.hilt.lazy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class LazyActivity : AppCompatActivity() {
    // 'Lazy' objects will ALWAYS return the same instance.
    @Inject
    lateinit var lazyCar: Lazy<Car>

    // 'Provider' objects will return new instances if the objects' scope allows it.
    @Inject
    lateinit var carProvider: Provider<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.padding(16.dp)) {
                Text("Lazy:")
                Text(text = lazyCar.get().make)
                Text(text = lazyCar.get().make)
                Text(text = lazyCar.get().make)

                Text("Provider:", Modifier.padding(top = 8.dp))
                Text(text = carProvider.get().make)
                Text(text = carProvider.get().make)
                Text(text = carProvider.get().make)
            }
        }
    }
}