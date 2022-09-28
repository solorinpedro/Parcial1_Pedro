package edu.ucne.parcial1_pedro.view

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_pedro.data.repository.ArticuloRepository
import javax.inject.Inject

@HiltViewModel
class ArticuloViewModel @Inject constructor(
    val articuloRepository: ArticuloRepository

):ViewModel(){

}

