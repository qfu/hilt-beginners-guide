package com.github.mrbean355.android.hilt.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.github.mrbean355.android.hilt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComponentsActivity : AppCompatActivity(R.layout.activity_components) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ComposeView>(R.id.compose_view).setContent {

        }
    }
}

@AndroidEntryPoint
class ComponentsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {

            }
        }
    }
}