package edu.ucne.parcial1_pedro.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.parcial1_pedro.data.local.entity.Articulo
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticuloDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    suspend fun Insertar(articulo: Articulo)

        @Query(
            " SELECT * FROM Articulos ORDER BY articuloId"
        )
        fun Lista():Flow<List<Articulo>>
}