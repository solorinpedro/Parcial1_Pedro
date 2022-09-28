package edu.ucne.parcial1_pedro.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_pedro.data.local.dao.ArticuloDao
import edu.ucne.parcial1_pedro.data.local.entity.Articulo

@Database(
    entities = [
        Articulo::class],
    exportSchema = false,
    version = 3
)
abstract class ArticulosDb : RoomDatabase() {
    abstract val articuloDao: ArticuloDao
}