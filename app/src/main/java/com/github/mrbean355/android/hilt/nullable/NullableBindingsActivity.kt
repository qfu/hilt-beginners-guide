package com.github.mrbean355.android.hilt.nullable

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NullableBindingsActivity : AppCompatActivity() {
    // Injection site must also be nullable. Use @Nullable in Java.
    @Inject
    @JvmField // necessary when injecting non-lateinit properties in Kotlin.
    var house: House? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val house = house
        setContent {
            if (house != null) {
                Text(text = "size = ${house.size}m²", Modifier.padding(16.dp))
            } else {
                Text(text = "Null house!", Modifier.padding(16.dp))
            }
        }
    }
}