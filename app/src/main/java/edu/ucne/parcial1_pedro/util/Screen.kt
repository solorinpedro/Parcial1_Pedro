package edu.ucne.parcial1_pedro.util

sealed class Screen(val route: String) {
    object RegistroScreen: Screen("RegistroScreen")
    object ListadoScreen: Screen("ListadoScreen")
}