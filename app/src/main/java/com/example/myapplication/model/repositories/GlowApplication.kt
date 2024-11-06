package com.example.myapplication.model.repositories

import android.app.Application
import com.example.myapplication.model.repositories.AppContainer
import com.example.myapplication.model.repositories.AppDataContainer

class GlowApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }


}
