package edu.ucne.parcial1_pedro.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_pedro.data.local.entity.Persona

@Database(
    entities = [
        Persona::class],
    exportSchema = false,
    version = 2
)
abstract class PersonasDb : RoomDatabase() {
}