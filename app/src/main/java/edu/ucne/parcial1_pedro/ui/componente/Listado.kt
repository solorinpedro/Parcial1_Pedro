package edu.ucne.parcial1_pedro.ui.theme.Componentes

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable

@Composable
fun listado(goToRegistro:() -> Unit){
    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "listado") })
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goToRegistro()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Nuevo")
            }
        },
        scaffoldState = ScaffoldState

    ){it

    }

}