package com.mixo.application

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication

class MixoApplication : MultiDexApplication() {

    companion object {
        lateinit var instance: MixoApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

}