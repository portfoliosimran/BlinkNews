package com.sandhu.blinknews.di

import android.app.Application
import com.google.gson.GsonBuilder
import com.sandhu.blinknews.data.manager.LocalUserManagerImpl
import com.sandhu.blinknews.data.remote.NewsApi
import com.sandhu.blinknews.data.repository.NewsRepositoryImpl
import com.sandhu.blinknews.domain.manager.LocalUserManager
import com.sandhu.blinknews.domain.repository.NewsRepository
import com.sandhu.blinknews.domain.usecases.app_entry.AppEntryUseCases
import com.sandhu.blinknews.domain.usecases.app_entry.ReadAppEntry
import com.sandhu.blinknews.domain.usecases.app_entry.SaveAppEntry
import com.sandhu.blinknews.domain.usecases.news.GetNews
import com.sandhu.blinknews.domain.usecases.news.NewsUseCases
import com.sandhu.blinknews.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }


}