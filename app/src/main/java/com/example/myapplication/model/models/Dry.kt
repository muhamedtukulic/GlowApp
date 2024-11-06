package com.example.myapplication.model.models
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Dry")
data class Dry(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "productId")
    val productId: Int = 0,
    @ColumnInfo(name = "productType")
    val productType: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "image_url")
    val image_url: String
)
