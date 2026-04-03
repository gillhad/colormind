package com.gillhad.domain.repositories

interface PreferenceRepository {

    fun getString(key: String): String?

    //TODO: at some point should i need better a null value?
    fun getInt(key: String): Int
}