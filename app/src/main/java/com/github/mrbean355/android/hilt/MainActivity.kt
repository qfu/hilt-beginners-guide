package com.github.mrbean355.android.hilt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.mrbean355.android.hilt.basics.BasicsActivity
import com.github.mrbean355.android.hilt.combination.CombinationActivity
import com.github.mrbean355.android.hilt.components.ComponentsActivity
import com.github.mrbean355.android.hilt.lazy.LazyActivity
import com.github.mrbean355.android.hilt.multibindings.MultiBindingsActivity
import com.github.mrbean355.android.hilt.nullable.NullableBindingsActivity
import com.github.mrbean355.android.hilt.optional.OptionalBindingsActivity
import com.github.mrbean355.android.hilt.qualifiers.QualifiersActivity
import com.github.mrbean355.android.hilt.scopes.ScopesActivity
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                DemoItem(stringResource(R.string.title_basics)) { BasicsActivity::class.start() }
                DemoItem(stringResource(R.string.title_components)) { ComponentsActivity::class.start() }
                DemoItem(stringResource(R.string.title_qualifiers)) { QualifiersActivity::class.start() }
                DemoItem(stringResource(R.string.title_scopes)) { ScopesActivity::class.start() }
                DemoItem(stringResource(R.string.title_lazy_bindings)) { LazyActivity::class.start() }
                DemoItem(stringResource(R.string.title_nullable_bindings)) { NullableBindingsActivity::class.start() }
                DemoItem(stringResource(R.string.title_optional_bindings)) { OptionalBindingsActivity::class.start() }
                DemoItem(stringResource(R.string.title_multi_bindings)) { MultiBindingsActivity::class.start() }
                DemoItem(stringResource(R.string.title_combination)) { CombinationActivity::class.start() }
            }
        }
    }

    private fun KClass<out Activity>.start() {
        startActivity(Intent(this@MainActivity, this.java))
    }
}

@Composable
fun DemoItem(label: String, onClick: () -> Unit) {
    Button(onClick) {
        Text(label)
    }
}