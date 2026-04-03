package com.gillhad.data.di

import android.content.Context
import android.content.SharedPreferences
import com.gillhad.data.repositories.PreferenceRepositoryImpl
import com.gillhad.domain.repositories.PreferenceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("colormind_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferenceRepository(
        sharedPreferences: SharedPreferences
    ): PreferenceRepository {
        return PreferenceRepositoryImpl(sharedPreferences)
    }
}