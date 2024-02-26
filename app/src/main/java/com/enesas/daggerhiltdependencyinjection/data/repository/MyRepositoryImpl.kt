package com.enesas.daggerhiltdependencyinjection.data.repository

import android.app.Application
import com.enesas.daggerhiltdependencyinjection.R
import com.enesas.daggerhiltdependencyinjection.data.remote.MyApi
import com.enesas.daggerhiltdependencyinjection.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Application // Peki ya bu şekilde context vermemiz gerekirse?

    /**
    Şimdi burada oluşturduğum dummy api olan MyApi'ya ulaşmak için dependency inj kullanacağız.
    Fakat dagger-hilt bu oluşturduğum api objesini burada kullanacağımı nasıl bilecek?
    Tabiki bilemeyecek, biz söylemeden. Bunu module'ler ile söyleceğiz.
     **/
) : MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Repositoryden geldim. App name is $appName")
    }

    override suspend fun doNetworkCall() {

    }
}