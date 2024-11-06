package com.example.myapplication.model.dao

import androidx.room.Dao

import androidx.room.Delete

import androidx.room.Insert

import androidx.room.OnConflictStrategy

import androidx.room.Query

import androidx.room.Update

import com.example.myapplication.model.models.Combined

import kotlinx.coroutines.flow.Flow




@Dao

interface combinedDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)

    suspend fun insert(combined: Combined)




    @Update

    suspend fun update(combined: Combined)




    @Delete

    suspend fun delete(combined: Combined)




    @Query("SELECT * FROM Combined WHERE productId = :id")

    fun getCombined(id: Int): Flow<Combined>




    @Query("SELECT * FROM Combined")

    fun getCombineds(): Flow<List<Combined>>

}