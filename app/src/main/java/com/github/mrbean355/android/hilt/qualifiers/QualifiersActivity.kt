package com.github.mrbean355.android.hilt.qualifiers

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
class QualifiersActivity : AppCompatActivity() {
    @Inject
    @Android
    lateinit var androidPhone: Phone

    @Inject
    @Ios
    lateinit var iosPhone: Phone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.padding(16.dp)) {
                Text(text = "Android: ${androidPhone.model}")
                Text(text = "iOS: ${iosPhone.model}", Modifier.padding(top = 8.dp))
            }
        }
    }
}