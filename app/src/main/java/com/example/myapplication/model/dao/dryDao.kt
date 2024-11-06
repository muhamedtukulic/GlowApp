package com.example.myapplication.model.dao

import androidx.room.Dao

import androidx.room.Delete

import androidx.room.Insert

import androidx.room.OnConflictStrategy

import androidx.room.Query

import androidx.room.Update

import com.example.myapplication.model.models.Dry

import kotlinx.coroutines.flow.Flow




@Dao

interface dryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)

    suspend fun insert(dry: Dry)




    @Update

    suspend fun update(dry: Dry)




    @Delete

    suspend fun delete(dry: Dry)




    @Query("SELECT * FROM Dry WHERE productId = :id")

    fun getDry(id: Int): Flow<Dry>




    @Query("SELECT * FROM Dry")

    fun getDrys(): Flow<List<Dry>>

}