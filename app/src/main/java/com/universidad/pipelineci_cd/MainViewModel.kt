package com.universidad.pipelineci_cd

import androidx.lifecycle.ViewModel
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig

class MainViewModel : ViewModel() {
    private val remoteConfig = Firebase.remoteConfig

    init {
        remoteConfig.setDefaultsAsync(
            mapOf("new_home_screen_enabled" to false)
        )
        remoteConfig.fetchAndActivate()
    }

    val isNewHomeEnabled: Boolean
        get() = remoteConfig.getBoolean("new_home_screen_enabled")
}
