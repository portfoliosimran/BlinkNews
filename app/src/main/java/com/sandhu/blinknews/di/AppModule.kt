package com.sandhu.blinknews.di

import android.app.Application
import com.sandhu.blinknews.data.manager.LocalUserManagerImpl
import com.sandhu.blinknews.domain.manager.LocalUserManager
import com.sandhu.blinknews.domain.usecases.app_entry.AppEntryUseCases
import com.sandhu.blinknews.domain.usecases.app_entry.ReadAppEntry
import com.sandhu.blinknews.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


}