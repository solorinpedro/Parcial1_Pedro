package edu.ucne.parcial1_pedro.ui.theme.Componentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.parcial1_pedro.view.ArticuloViewModel

@Composable
fun listado(goToRegistro:() -> Unit, viewModel: ArticuloViewModel = hiltViewModel()){
    val ScaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listado de Articulos") })
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

        val ListadoArticulos = viewModel.articulo.collectAsState(initial = emptyList())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()) {
            items(ListadoArticulos.value) { articulos ->
                Column(modifier = Modifier.fillMaxWidth())
                {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                            .padding(2.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "${articulos.Descripcion}"

                        )
                        Text(
                            text = "${articulos.Marca}"
                        )

                        Text(
                            text = "${articulos.Existencia}",
                            style = MaterialTheme.typography.h5
                        )
                    }
                }
            }
        }
    }
}
