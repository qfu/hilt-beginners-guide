package com.github.mrbean355.android.hilt.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.github.mrbean355.android.hilt.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ComponentsActivity : AppCompatActivity(R.layout.activity_components) {
    @Inject
    lateinit var appMonitor: AppMonitor

    @Inject
    lateinit var activityMonitor: ActivityMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ComposeView>(R.id.compose_view).setContent {
            Column(Modifier.padding(16.dp)) {
                Text(text = "Activity:")
                Text(text = "appMonitor.application = ${appMonitor.application.toDemoString()}")
                Text(text = "activityMonitor.activity = ${activityMonitor.activity.toDemoString()}")
            }
        }
    }
}

@AndroidEntryPoint
class ComponentsFragment : Fragment() {
    @Inject
    lateinit var appMonitor: AppMonitor

    @Inject
    lateinit var activityMonitor: ActivityMonitor

    @Inject
    lateinit var fragmentMonitor: FragmentMonitor

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(Modifier.padding(16.dp)) {
                    Text(text = "Fragment:")
                    Text(text = "appMonitor.application = ${appMonitor.application.toDemoString()}")
                    Text(text = "activityMonitor.activity = ${activityMonitor.activity.toDemoString()}")
                    Text(text = "fragmentMonitor.fragment = ${fragmentMonitor.fragment.toDemoString()}")
                }
            }
        }
    }
}

private fun Any.toDemoString() = toString().substringAfterLast('.')