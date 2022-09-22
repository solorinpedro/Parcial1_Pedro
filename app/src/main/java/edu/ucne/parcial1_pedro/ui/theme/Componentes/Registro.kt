package edu.ucne.parcial1_pedro.ui.theme.Componentes

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.SaveAs
import androidx.compose.runtime.Composable

@Composable
fun Registro(backToListado:() -> Unit){
    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro") })
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    backToListado()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.SaveAs, contentDescription = "Nuevo")
            }
        },
        scaffoldState = ScaffoldState

    ){it

    }

}