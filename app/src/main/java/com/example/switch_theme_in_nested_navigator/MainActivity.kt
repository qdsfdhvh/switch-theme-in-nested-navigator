package com.example.switch_theme_in_nested_navigator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import com.example.switch_theme_in_nested_navigator.ui.theme.SwitchthemeinnestednavigatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isNight by remember {
                mutableStateOf(false)
            }
            SwitchthemeinnestednavigatorTheme(isNight) {
                Navigator(HiddenScreen) {
                    Navigator(HiddenScreen) { // ✅ if hide this line
                        Scaffold { innerPadding ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .padding(innerPadding)
                                    .fillMaxSize(),
                            ) {
                                Button(onClick = { isNight = !isNight }) {
                                    Text("Button1")
                                }
                                ElevatedButton(onClick = { isNight = !isNight }) {
                                    Text(text = "Button2")
                                }
                                FilledTonalButton(onClick = { isNight = !isNight }) {
                                    Text(text = "Button3")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

object HiddenScreen : Screen {
    private fun readResolve(): Any = HiddenScreen

    @Composable
    override fun Content() {
    }
}

object HomeScreen : Screen {
    private fun readResolve(): Any = HomeScreen

    @Composable
    override fun Content() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            Button(onClick = {}) {
                Text("Button1")
            }
            ElevatedButton(onClick = {}) {
                Text(text = "Button2")
            }
            FilledTonalButton(onClick = {}) {
                Text(text = "Button3")
            }
        }
    }
}