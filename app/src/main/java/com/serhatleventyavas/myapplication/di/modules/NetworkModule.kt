package com.serhatleventyavas.myapplication.di.modules

import android.os.Debug
import com.serhatleventyavas.myapplication.RestAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi, httpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }

    @Singleton
    @Provides
    fun provideServices(retrofit: Retrofit.Builder): RestAPI {
        var url = ""

        return retrofit
            .baseUrl("https://api.news.com/")
            .build()
            .create(RestAPI::class.java)
    }
}