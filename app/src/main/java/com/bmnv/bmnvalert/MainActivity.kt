package com.bmnv.bmnvalert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bmnv.bmnvalert.base.BMNVAlert
import com.bmnv.bmnvalert.ui.theme.BMNVAlertTheme
import com.bmnv.bmnvalert.utils.AlertType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMNVAlertTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BMNVAlert.CreateConfirmationAlert(
                        alertType = AlertType.INFO,
                        title = "Confirmation Alert Title",
                        message = "Confirmation Test Message",
                        onDismiss = {},
                        onConfirm = {}
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMNVAlertTheme {
        Greeting("Android")
    }
}