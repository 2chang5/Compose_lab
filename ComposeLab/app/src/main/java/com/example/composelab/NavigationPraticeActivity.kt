package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class NavigationPraticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "first") {
                composable("first") {
                    FirstScreen(navController)
                }
                composable("second") {
                    SecondScreen(navController)
                }
                composable("third/{value}") { backStackEntry ->
                    ThirdScreen(navController, backStackEntry.arguments?.getString("value") ?: "")
                }
            }
        }
    }
}


@Composable
fun FirstScreen(navController: NavController) {
    val (edittextValue, valueChangeListener) = rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("첫화면")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("second")
        }) {
            Text("간다간다 두번째로")
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = edittextValue, onValueChange = valueChangeListener)
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            navController.navigate("third/$edittextValue")
        }) {
            Text("세번쨰로 가자")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    val dummyNavController = rememberNavController()
    FirstScreen(dummyNavController)
}


@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("두번쨰 화면에 온걸 환영합니다")
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            // 둘다 비슷한 동작
//            navController.navigateUp()
            navController.popBackStack()
        }) {
            Text("백버튼")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    val dummyNavController = rememberNavController()
    SecondScreen(dummyNavController)
}


@Composable
fun ThirdScreen(navController: NavController, value: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("세번째 화면입니다.")
        Spacer(modifier = Modifier.height(12.dp))
        Text(value)
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("뒤로기가")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview() {
    val dummyNavController = rememberNavController()
    ThirdScreen(dummyNavController, "외부에서 넣어준값")
}
