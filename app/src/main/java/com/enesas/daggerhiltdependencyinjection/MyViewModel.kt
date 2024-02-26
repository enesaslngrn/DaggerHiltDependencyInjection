package com.enesas.daggerhiltdependencyinjection

import androidx.lifecycle.ViewModel
import com.enesas.daggerhiltdependencyinjection.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    /**
     * Diyoruz ki: Merhaba dagger, lütfen constructor içindeki tüm bu objeleri inject et.
     * Ardından git ve AppModule'bak bakalım orada bulabilecekmisin nasıl inject edeceğini.
     */
    private val repository: MyRepository
    /**
     * Burada viewmodel'lara dependency inject etmeye bakacağız. ProviderFactory kullanmak gibi.
     * Bildiğimiz gibi viewmodel'larda factory olmadan constructor ile bir obje oluşturamıyoruz.
     * Bu aslında hiç flexible değil çünkü birden fazla viewmodel olursa hepsine yapmamız gerekecek.
     * Ama Dagger-Hilt ile bunu çözüyoruz. Gidip appmodule içinde dagger-hilt'e söyledik MyRepository'i nasıl inject etmesi gerektiğini.
     */
) : ViewModel() {
}