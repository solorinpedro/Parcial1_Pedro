package edu.ucne.parcial1_pedro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcial1_pedro.ui.theme.Componentes.Registro
import edu.ucne.parcial1_pedro.ui.theme.Componentes.listado
import edu.ucne.parcial1_pedro.utlis.theme.Parcial1_PedroTheme
import edu.ucne.parcial1_pedro.util.Screen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1_PedroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    myApp()
                }
            }
        }
    }
}

@Composable
fun myApp() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController,
        startDestination = Screen.ListadoArticulosScreen.route){

        composable(route = Screen.ListadoArticulosScreen.route){
            listado(goToRegistro = {navHostController.navigate(Screen.RegistroArticulosScreen.route)})
        }

        composable(route = Screen.RegistroArticulosScreen.route){
            Registro(backToListado = {navHostController.navigate(Screen.ListadoArticulosScreen.route)})
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Parcial1_PedroTheme {
        myApp()
    }
}