package com.enesas.daggerhiltdependencyinjection


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.enesas.daggerhiltdependencyinjection.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
        Dependency injection şu demek: Her hangi bir objenin değerini ilk başta belirlemek.
        Yani: Giving an object its instance variables.
        DI ile aslında dependency’ler activityler tarafından değil farklı bir kaynak tarafından yani module'ler oluşturulup kullanılması gerektiğinde activity’e verilmesi sağlanıyor.
        Hilt aslında arka planda birçok işlemi yapmak için Dagger’ı kullanan ve Dagger’ın çalışması için gerekli kodu yaratan bir frameworktur.
        Hilt kodu yazdırmak yerine bize küçük bir setup yaptırıp işi kendisi yapıyor. Böylece Hilt’in basitliğiyle dagger’ın tüm performansını elde etmiş oluyoruz.

        val test = Test("Enes") // Mesela constructor oluşturmak basitçe bir constructor injection oluyor.
        val hataliTest = HataliTest() // Yani böyle oluşturduğumuzda her seferinde name aynı olacak.
        // Mesela name'i değiştirince hepsi değişecek.


        Dagger-Hilt google tarafından geliştirilen ve bize bu konuda daha fazla flexibility ve tools veren bir kütüphane.
        Dagger ve Dagger-Hilt ayrı şeyler. Fakat Dagger-Hilt daha simple ve daha iyi.
        Dagger hilt ile constructor injection yerine daha farklı şekilde dependency injection yapacağız.
         Dagger hilt sayesinde bir objenin lifetime'ına karar verebiliyoruz. Yani sadece gerektiğinde çalışıp işi bitince bitiyor.Singleton buna bir örnek mesela

        **/
    }
}
class Test(val name : String)
class HataliTest{
    val name = "Enes"
}