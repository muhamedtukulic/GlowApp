package com.example.myapplication.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "articleId")
    val id: Int, // Unique identifier for each
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "image")
    val imageResId: Int // Resource ID for the image
)
