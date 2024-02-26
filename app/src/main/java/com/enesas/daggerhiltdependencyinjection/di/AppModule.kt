package com.enesas.daggerhiltdependencyinjection.di

import android.app.Application
import com.enesas.daggerhiltdependencyinjection.data.remote.MyApi
import com.enesas.daggerhiltdependencyinjection.data.repository.MyRepositoryImpl
import com.enesas.daggerhiltdependencyinjection.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Bu component şuna karar verecek: Ne kadar süreyle burada sağlanan dependencyler kullanılacak?
/**
 * SingletonComponent: Application açık kaldığı sürece onlarda yaşayacak.
 * ApplicationComponent: Inject edilen objelerin olduğu activity açık olduğu sürece yaşayacaklar.
 * ViewModelComponent: nject edilen objelerin olduğu viewmodel açık olduğu sürece yaşayacaklar.
 */

object AppModule {

    @Provides
    @Singleton // Bu singleton ise SCOPE olarak geçiyor. Yani burada singleton olarak belirtmezsek her obje oluşturulduğunda uygulama kapanana kadar yeni bir instance oluşturulur. Bunu istemiyoruz. Ne kadar request yaparsak yapalım aynı instance'ı alsın istiyoruz.
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
        /**
         * Yani artık ne zaman bir MyApi instance'ı oluşturulması için request yaparsak yapalım.
         * Dagger hilt gidip bu module bakacak ve objenin oluşturulduğu yere buradaki verileri iletecek.
         */
    }

    @Provides
    @Singleton
    fun provideMyRepository(api: MyApi, app: Application): MyRepository{
        return MyRepositoryImpl(api, app) // Şimdi buraya yukarda dagger-hilt ile oluşturduğumuz MyApi instance'ını vermemiz gerek.
    }
}