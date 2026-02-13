package com.example.retrofitjc_di.modules

import com.example.retrofitjc_di.api.ApiInterface
import com.example.retrofitjc_di.repo.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRepository(apiInterface: ApiInterface): ApiRepository{
        return ApiRepository(apiInterface)
    }
}