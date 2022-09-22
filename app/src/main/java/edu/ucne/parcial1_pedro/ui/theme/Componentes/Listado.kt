package edu.ucne.parcial1_pedro.ui.theme.Componentes

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable

@Composable
fun listado(){
    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "listado") })
        },
        scaffoldState = ScaffoldState

    ){it

    }

}