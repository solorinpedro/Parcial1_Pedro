package edu.ucne.parcial1_pedro.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Personas")
data class Persona(
@PrimaryKey (autoGenerate = true)
val personaId: Int,
val nombre: String,
val direccion: String,
val Sueldo: Double
)

