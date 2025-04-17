package com.example.bodyhubfitnessapp.data

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferences(private val context: Context) {

    companion object {
        val EMAIL_KEY = stringPreferencesKey("email")
        val PASSWORD_KEY = stringPreferencesKey("password")
    }

    suspend fun saveCredentials(email: String, password: String) {
        context.dataStore.edit { prefs ->
            prefs[EMAIL_KEY] = email
            prefs[PASSWORD_KEY] = password
        }
    }

    suspend fun getEmail(): String? {
        return context.dataStore.data.map { it[EMAIL_KEY] }.first()
    }

    suspend fun getPassword(): String? {
        return context.dataStore.data.map { it[PASSWORD_KEY] }.first()
    }
}