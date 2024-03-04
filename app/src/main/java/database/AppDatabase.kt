package database

import androidx.room.Database
import androidx.room.RoomDatabase

// Incrementa la versión de la base de datos aquí.
@Database(entities = [User::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
