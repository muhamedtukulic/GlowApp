package com.example.myapplication.model.dao

import androidx.room.Dao

import androidx.room.Delete

import androidx.room.Insert

import androidx.room.OnConflictStrategy

import androidx.room.Query

import androidx.room.Update

import com.example.myapplication.model.models.User

import kotlinx.coroutines.flow.Flow




@Dao

interface userDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)

    suspend fun insert(user: User)




    @Update

    suspend fun update(user: User)




    @Delete

    suspend fun delete(user: User)




    @Query("SELECT * FROM User WHERE userId = :id")

    fun getUser(id: Int): Flow<User>




    @Query("SELECT * FROM User")

    fun getUsers(): Flow<List<User>>
    @Query("SELECT * FROM User WHERE email = :email")
    fun getEmailUser(email: String): Flow<User>

    @Query("SELECT * FROM User WHERE password = :password AND email = :email")
    fun login(password: String, email: String): Flow<User?>


}