package br.com.douglasmotta.room_coroutines.data.db.repository

import br.com.douglasmotta.room_coroutines.data.db.model.User
import br.com.douglasmotta.room_coroutines.ui.registration.RegistrationViewParams

interface UserRepository {

    suspend fun createUser(registrationViewParams: RegistrationViewParams)

    fun getUser(id: Long) : User

    fun login (username: String, password: String) : Long
}