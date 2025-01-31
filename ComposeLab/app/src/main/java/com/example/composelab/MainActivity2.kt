package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelab.ui.theme.ComposeLabTheme
import kotlinx.coroutines.launch

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLabTheme {
                /**Scafold 머테리얼 디자인 요소를 사용하기 위한 수단이라함
                 * 스낵바,fab같은거 다룰때 쓴다고함*/
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    val editTextUIModifier = Modifier.fillMaxSize()
                    EditTextUI(editTextUIModifier)
                }
            }
        }
    }
}

@Composable
private fun EditTextUI(
    modifier: Modifier = Modifier
) {
    val (text, setText) = rememberSaveable {
        mutableStateOf("")
    }

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope() /** 컴포즈의 생명주기를 따라가는 스코프*/
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) { _ ->
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(value = text, onValueChange = setText)

            Button(onClick = {
                keyboardController?.hide()
                scope.launch {
                    snackBarHostState.showSnackbar(
                        message = "차려오거라"
                    )
                }
            }) {
                Text("햄부기 햄부가우가")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditTextUIPreview() {
    val previewModifier = Modifier.fillMaxSize()
    EditTextUI(previewModifier)
}
