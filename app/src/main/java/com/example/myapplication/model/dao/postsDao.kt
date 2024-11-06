package com.example.myapplication.model.dao

import androidx.room.Dao

import androidx.room.Delete

import androidx.room.Insert

import androidx.room.OnConflictStrategy

import androidx.room.Query

import androidx.room.Update

import com.example.myapplication.model.models.Posts

import kotlinx.coroutines.flow.Flow




@Dao

interface postsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)

    suspend fun insert(posts: Posts)




    @Update

    suspend fun update(posts: Posts)




    @Delete

    suspend fun delete(posts: Posts)




    @Query("SELECT * FROM Posts WHERE postId = :id")

    fun getPost(id: Int): Flow<Posts>




    @Query("SELECT * FROM Posts")

    fun getPosts(): Flow<List<Posts>>

}