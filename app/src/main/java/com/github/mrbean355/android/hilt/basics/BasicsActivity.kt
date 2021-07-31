package com.github.mrbean355.android.hilt.basics

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class BasicsActivity : AppCompatActivity() {
    private val viewModel: BasicsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val beers by viewModel.beers.observeAsState()
            BeerList(beers.orEmpty())
        }
        viewModel.initialise()
    }
}

@Composable
fun BeerList(beers: List<Beer>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(beers) { index, it ->
            Text(it.name, style = MaterialTheme.typography.body1)
            Text(it.tagline, style = MaterialTheme.typography.body2)
            if (index < beers.size - 1) {
                Divider(Modifier.padding(top = 8.dp))
            }
        }
    }
}