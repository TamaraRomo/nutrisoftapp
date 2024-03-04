package database

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildRoomDB(context).also { INSTANCE = it }
        }
    }

    private fun buildRoomDB(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, "nutrisoftapp-db"
    )
        .fallbackToDestructiveMigration() // Agrega esta línea si no te importa perder los datos al actualizar la versión.
        .build()
}
