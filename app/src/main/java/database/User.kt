package database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // El valor predeterminado para 'id' es necesario para que Room pueda autogenerar el ID
    val fullName: String,
    val professionalId: String,
    val phoneNumber: String,
    val email: String,
    val password: String
)
