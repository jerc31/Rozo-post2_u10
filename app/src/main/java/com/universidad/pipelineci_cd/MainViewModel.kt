package com.universidad.pipelineci_cd

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings

class MainViewModel(
    private val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
) : ViewModel() {

    var isNewHomeEnabled by mutableStateOf(false)
        private set

    init {
        configurarRemoteConfig()
    }

    private fun configurarRemoteConfig() {

        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }

        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.setDefaultsAsync(
            mapOf(
                "new_home_screen_enabled" to false
            )
        )

        fetchRemoteConfig()
    }

    private fun fetchRemoteConfig() {

        remoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    isNewHomeEnabled =
                        remoteConfig.getBoolean("new_home_screen_enabled")
                }
            }
    }
}