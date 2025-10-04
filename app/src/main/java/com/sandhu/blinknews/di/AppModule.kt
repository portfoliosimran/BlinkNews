package com.sandhu.blinknews.di

import android.app.Application
import com.sandhu.blinknews.data.manager.LocalUserManagerImpl
import com.sandhu.blinknews.domain.manager.LocalUserManager
import com.sandhu.blinknews.domain.usecases.AppEntryUseCases
import com.sandhu.blinknews.domain.usecases.ReadAppEntry
import com.sandhu.blinknews.domain.usecases.SaveAppEntry
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