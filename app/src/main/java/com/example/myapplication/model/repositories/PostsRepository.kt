package com.example.myapplication.model.repositories

import com.example.myapplication.model.dao.postsDao
import com.example.myapplication.model.dao.userDao
import com.example.myapplication.model.models.Posts
import com.example.myapplication.model.models.User
import kotlinx.coroutines.flow.Flow

class PostsRepository(private val PostsDao: postsDao): BaseRepository<Posts> {

    override suspend fun insert(t: Posts) = PostsDao.insert(t)




    override suspend fun update(t: Posts) = PostsDao.update(t)




    override suspend fun delete(t: Posts) = PostsDao.delete(t)




    override fun getOneStream(id: Int): Flow<Posts?> = PostsDao.getPost(id)




    fun getPosts(): Flow<List<Posts>> = PostsDao.getPosts()




}