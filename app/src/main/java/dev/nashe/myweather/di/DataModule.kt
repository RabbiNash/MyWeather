package dev.nashe.myweather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.nashe.data.BuildConfig
import dev.nashe.data.api.ApiService
import dev.nashe.data.api.RetrofitServiceFactory
import dev.nashe.data.repository.WeatherRepositoryImpl
import dev.nashe.domain.repositories.WeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    companion object {
        @Provides
        @Singleton
        fun providesApiService(): ApiService {
            return RetrofitServiceFactory.makeRetrofitApiService(BuildConfig.DEBUG)
        }

        @Provides
        @Singleton
        fun providesWeatherRepository(weatherRepository: WeatherRepositoryImpl): WeatherRepository = weatherRepository

    }
}