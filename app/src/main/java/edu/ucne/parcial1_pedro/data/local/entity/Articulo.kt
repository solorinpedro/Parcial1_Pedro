package edu.ucne.parcial1_pedro.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Articulos")
data class Articulo(
@PrimaryKey (autoGenerate = true)
val articuloId: Int,
val Descripcion: String,
val Marca: String,
val Existencia: Double
)

