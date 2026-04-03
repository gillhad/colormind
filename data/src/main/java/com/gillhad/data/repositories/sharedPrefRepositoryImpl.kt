package com.gillhad.data.repositories

import android.content.SharedPreferences
import com.gillhad.domain.repositories.PreferenceRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : PreferenceRepository {

    //TODO: deberia crear funciones especificas para cosas que guardo?
    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    override fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }
}