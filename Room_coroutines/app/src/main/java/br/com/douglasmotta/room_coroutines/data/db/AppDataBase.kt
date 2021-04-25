package br.com.douglasmotta.room_coroutines.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.douglasmotta.room_coroutines.data.db.dao.UserDao

// se houver varias entidades: [UserEntity::class, Exemplo1::class, Exemplo2::class], version = x
@Database(entities = [UserEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object{

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase{

            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}