package edu.ucne.parcial1_pedro.ui.theme.Componentes

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.SaveAs
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_pedro.view.ArticuloViewModel

@Composable
fun Registro(backToListado:() -> Unit, viewModel: ArticuloViewModel = hiltViewModel()){
    val ScaffoldState = rememberScaffoldState()

    var validarDescripcion by remember{ mutableStateOf(false)}
    var validarMarca by remember{ mutableStateOf(false)}
    var validarExistencia by remember{ mutableStateOf(false)}
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro") })
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    validarDescripcion = viewModel.Descripcion.isBlank()
                    validarMarca = viewModel.Marca.isBlank()
                    validarExistencia = viewModel.Existencia.isBlank()

                    if(viewModel.Descripcion== ""){
                        Toast.makeText(context, "La Descripcion no debe estar vacio", Toast.LENGTH_SHORT).show()
                    }

                    if(viewModel.Marca == ""){
                        Toast.makeText(context, "La Marca no debe estar vacia", Toast.LENGTH_SHORT).show()
                    }

                    if(viewModel.Existencia == ""){
                        Toast.makeText(context, "La existencia no  debe estar vacia y debe de ser mayor a 0", Toast.LENGTH_SHORT).show()
                    }

                    if(!validarDescripcion && !validarMarca && !validarExistencia){
                        if(viewModel.Existencia.toDouble() > 0 && viewModel.Existencia.isDigitsOnly()){
                            viewModel.Guardar()
                            Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show()
                            backToListado()
                        }else{
                            Toast.makeText(context, "La Existencia de ser mayor a 0", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.SaveAs, contentDescription = "Nuevo")
            }
        },
        scaffoldState = ScaffoldState

    ){it
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {

            TextField(
                value = viewModel.Descripcion,
                onValueChange = {viewModel.Descripcion = it} ,
                label = { Text(text = "Descripcion")},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Default.Description, contentDescription ="")}

            )
            TextField(
                value = viewModel.Marca,
                onValueChange = {viewModel.Marca = it} ,
                label = { Text(text = "Marca")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                leadingIcon = { Icon(imageVector = Icons.Default.Article, contentDescription ="")}

            )
            TextField(
                value = viewModel.Existencia,
                onValueChange = {viewModel.Existencia = it} ,
                label = { Text(text = "Existencia")},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(imageVector = Icons.Default.Numbers, contentDescription ="")}

            )
        }
    }
}





