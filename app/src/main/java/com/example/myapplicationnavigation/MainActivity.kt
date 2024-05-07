package com.example.myapplicationnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationnavigation.ui.theme.MyApplicationNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationNavigationTheme {
                MyNav(navHostController = rememberNavController())
            }
        }
    }
}

@Composable
fun MyNav(navHostController: NavHostController){

    NavHost(navController = navHostController, startDestination = "myGridScreen"){
        composable("myGridScreen"){
            MyGridScreen(navHostController)
        }
        composable("myNumberScreen/{number}"){navBackStackEntry ->
            MyNumberScreen(number = navBackStackEntry.arguments?.getString("number"))
        }
    }
}
@Composable
fun MyGridScreen(navHostController: NavHostController){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(20.dp)
    ) {

        items(15) { number ->

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .border(1.dp, Color.Black)
                    .clickable {
                        navHostController.navigate("myNumberScreen/$number")
                    }
            ) {
                Text(
                    text = number.toString(),
                    fontSize = 30.sp
                )
            }

        }

    }
}

@Composable
fun MyNumberScreen(number : String?){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = number.toString(),
            fontSize = 70.sp
        )
    }
}

//@Composable
//fun MyScreen1(navController: NavHostController){
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Screen1",
//            fontSize = 30.sp
//        )
//
//        Button(onClick = {
//            navController.navigate("myScreen2")
//        }) {
//            Text(
//                text = "Go to Screen2",
//                fontSize = 30.sp
//            )
//        }
//    }
//}
//
//@Composable
//fun MyScreen2(navController: NavHostController){
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Screen2",
//            fontSize = 30.sp
//        )
//
//        Button(onClick = {
//            navController.navigate("myScreen3")
//        }) {
//            Text(
//                text = "Go to Screen3",
//                fontSize = 30.sp
//            )
//        }
//    }
//}
//
//@Composable
//fun MyScreen3(navController: NavHostController){
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Screen3",
//            fontSize = 30.sp
//        )
//
//        Button(onClick = {
//            navController.navigate("myScreen1")
//        }) {
//            Text(
//                text = "Go to Screen1",
//                fontSize = 30.sp
//            )
//        }
//    }
//}
//
//@Composable
//fun MyNav(){
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "myScreen1"){
//        composable("myScreen1"){
//            MyScreen1(navController = navController)
//        }
//        composable("myScreen2"){
//            MyScreen2(navController = navController)
//        }
//        composable("myScreen3"){
//            MyScreen3(navController = navController)
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationNavigationTheme {
//        MyNav()
//        MyGridScreen()
    }
}