package com.example.bodyhubfitnessapp.data

import android.accounts.AccountManager.KEY_PASSWORD
import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferences(private val context: Context) {

    companion object {
        val EMAIL_KEY = stringPreferencesKey("email")
        val USERNAME_KEY = stringPreferencesKey("username")
        val PASSWORD_KEY = stringPreferencesKey("password")
    }

    suspend fun saveCredentials(email: String,username: String, password: String) {
        context.dataStore.edit { prefs ->
            prefs[EMAIL_KEY] = email
            prefs[USERNAME_KEY] = username
            prefs[PASSWORD_KEY] = password
        }
    }

    suspend fun getEmail(): String? {
        return context.dataStore.data.map { it[EMAIL_KEY] }.first()
    }

    suspend fun getUserName(): String? {
        return context.dataStore.data.map { it[USERNAME_KEY]}.first()
    }

    suspend fun getPassword(): String? {
        return context.dataStore.data.map { it[PASSWORD_KEY] }.first()
    }

    suspend fun savePassword(password: String) {
        context.dataStore.edit { preferences ->
            preferences[PASSWORD_KEY] = password
        }
    }
}