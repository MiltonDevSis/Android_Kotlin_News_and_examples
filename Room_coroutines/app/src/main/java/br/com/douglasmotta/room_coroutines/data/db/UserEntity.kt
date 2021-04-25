package br.com.douglasmotta.room_coroutines.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.douglasmotta.room_coroutines.data.db.model.User
import br.com.douglasmotta.room_coroutines.ui.registration.RegistrationViewParams

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)val id: Long = 0,
    val name: String,
    val bio: String,
    val userName: String,
    val password: String
)

fun RegistrationViewParams.toUserEntity() : UserEntity{
    return with(this){
        UserEntity(
            name = this.name,
            userName = this.username,
            bio = this.bio,
            password = this.password
        )
    }
}

fun UserEntity.toUser() : User {
    return User(
        id = this.id.toString(),
        name = this.name,
        bio = this.bio
    )
}