package com.github.mrbean355.android.hilt.optional

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.common.base.Optional
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OptionalBindingsActivity : AppCompatActivity() {
    @Inject
    lateinit var money: Optional<Money>

    @Inject
    lateinit var creditCard: Optional<CreditCard>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.padding(16.dp)) {
                if (money.isPresent) {
                    Text(text = "Money: ${money.get().amount}")
                } else {
                    Text(text = "Money is missing!")
                }
                if (creditCard.isPresent) {
                    Text(text = "Credit card: ${creditCard.get().debt}", Modifier.padding(top = 8.dp))
                } else {
                    Text(text = "Credit card is missing!", Modifier.padding(top = 8.dp))
                }
            }
        }
    }
}