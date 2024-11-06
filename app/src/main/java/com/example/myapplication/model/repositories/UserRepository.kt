package com.example.myapplication.model.repositories

import com.example.myapplication.model.dao.userDao

import com.example.myapplication.model.models.User

import kotlinx.coroutines.flow.Flow




class UserRepository(private val UserDao: userDao): BaseRepository<User> {

    override suspend fun insert(t: User) = UserDao.insert(t)




    override suspend fun update(t: User) = UserDao.update(t)




    override suspend fun delete(t: User) = UserDao.delete(t)




    override fun getOneStream(id: Int): Flow<User?> = UserDao.getUser(id)



    fun getEmailUser(email: String): Flow<User> = UserDao.getEmailUser(email)

    fun login(password: String, email: String): Flow<User?> = UserDao.login(password, email)
    fun getUsers(): Flow<List<User>> = UserDao.getUsers()




}