package com.example.myapplication.model.dao

import androidx.room.Dao

import androidx.room.Delete

import androidx.room.Insert

import androidx.room.OnConflictStrategy

import androidx.room.Query

import androidx.room.Update

import com.example.myapplication.model.models.Oily

import kotlinx.coroutines.flow.Flow




@Dao

interface oilyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)

    suspend fun insert(oily: Oily)




    @Update

    suspend fun update(oily: Oily)




    @Delete

    suspend fun delete(oily: Oily)




    @Query("SELECT * FROM Oily WHERE productId = :id")

    fun getOily(id: Int): Flow<Oily>




    @Query("SELECT * FROM Oily")

    fun getOilys(): Flow<List<Oily>>

}