package edu.ucne.parcial1_pedro.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.parcial1_pedro.data.ArticulosDb
import edu.ucne.parcial1_pedro.data.local.dao.ArticuloDao
import edu.ucne.parcial1_pedro.data.repository.ArticuloRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesDataBase(@ApplicationContext context: Context) : ArticulosDb{
        return Room.databaseBuilder(
            context,
            ArticulosDb::class.java,
            "ArticulosDB"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun providesArticuloDao(articulosDb: ArticulosDb): ArticuloDao {
        return articulosDb.articuloDao
    }
    @Provides
    fun providesArticuloRepository(articuloDao: ArticuloDao): ArticuloRepository {
        return  ArticuloRepository(articuloDao)
    }
}