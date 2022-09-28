package edu.ucne.parcial1_pedro.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import edu.ucne.parcial1_pedro.data.local.entity.Articulo
import edu.ucne.parcial1_pedro.data.repository.ArticuloRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticuloViewModel @Inject constructor(
    val articuloRepository: ArticuloRepository


):ViewModel(){
    var articuloId by mutableStateOf("")
    var Descripcion by mutableStateOf("")
    var Marca by mutableStateOf("")
    var Existencia by mutableStateOf("")
    var articulo = articuloRepository.Lista()
    fun Guardar(){
        viewModelScope.launch{
            articuloRepository.Insertar(Articulo(
                articuloId = 0,
                Descripcion = Descripcion,
                Marca = Marca,
                Existencia = Existencia.toDouble()
            ))
        }
    }
}
