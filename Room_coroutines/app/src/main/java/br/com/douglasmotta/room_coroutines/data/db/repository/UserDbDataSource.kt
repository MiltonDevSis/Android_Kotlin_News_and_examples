package br.com.douglasmotta.room_coroutines.data.db.repository

import br.com.douglasmotta.room_coroutines.data.db.dao.UserDao
import br.com.douglasmotta.room_coroutines.data.db.model.User
import br.com.douglasmotta.room_coroutines.data.db.toUser
import br.com.douglasmotta.room_coroutines.data.db.toUserEntity
import br.com.douglasmotta.room_coroutines.ui.registration.RegistrationViewParams

class UserDbDataSource(
    private val userDao: UserDao
) : UserRepository{
    override suspend fun createUser(registrationViewParams: RegistrationViewParams) {
        val userEntity = registrationViewParams.toUserEntity()
        userDao.save(userEntity)
    }

    override fun getUser(id: Long): User {
        return userDao.getUser(id).toUser()
    }

    override fun login(username: String, password: String): Long {
        return userDao.login(username, password)
    }
}