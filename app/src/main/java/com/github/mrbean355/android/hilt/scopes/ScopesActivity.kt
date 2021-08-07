package com.github.mrbean355.android.hilt.scopes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ScopesActivity : AppCompatActivity() {
    @Inject
    lateinit var oreo1: Oreo

    @Inject
    lateinit var oreo2: Oreo

    @Inject
    lateinit var pie1: Pie

    @Inject
    lateinit var pie2: Pie

    @Inject
    lateinit var jetpack1: Jetpack

    @Inject
    lateinit var jetpack2: Jetpack

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.padding(16.dp)) {
                Text(text = "Oreo ${oreo1.number}")
                Text(text = "Oreo ${oreo2.number}")

                Text(text = "Pie ${pie1.number}", Modifier.padding(top = 8.dp))
                Text(text = "Pie ${pie2.number}")

                Text(text = "Jetpack ${jetpack1.number}", Modifier.padding(top = 8.dp))
                Text(text = "Jetpack ${jetpack2.number}")
            }
        }
    }
}