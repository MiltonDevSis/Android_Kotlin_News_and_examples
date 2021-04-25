package br.com.douglasmotta.room_coroutines.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.douglasmotta.room_coroutines.data.db.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUser(id: Long): UserEntity

    @Query("SELECT * FROM user WHERE userName = :username AND password = :password")
    fun login(username: String, password: String): Long
}