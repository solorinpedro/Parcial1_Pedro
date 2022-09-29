package edu.ucne.parcial1_pedro.util

sealed class Screen(val route: String) {
    object RegistroArticulosScreen: Screen("RegistroArticulosScreen")
    object ListadoArticulosScreen: Screen("ListadoArticulosScreen")
}