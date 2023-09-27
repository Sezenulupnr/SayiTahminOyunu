package com.example.sayiuretme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sayiuretme.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity(R.layout.activity_tahmin) {
    private lateinit var binding : ActivityTahminBinding

    private var rastgeleSayi = 0
    private var sayac = 5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rastgeleSayi = Random.nextInt(101) //0 ile 100 arası
        Log.e("Rastgele Sayı",rastgeleSayi.toString())

        binding.buttonTahmin.setOnClickListener{
            sayac = sayac -1

            val tahmin = binding.editTextSayiGir.text.toString().toInt()

            if(tahmin == rastgeleSayi){
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                //Sayfa geçişi
                intent.putExtra("sonuc",rastgeleSayi)
                intent.putExtra("sonuc1",true)
                //Diğer sayfaya sonuç gönderme //Kazandınız
                finish()
                startActivity(intent)

                return@setOnClickListener
                //Bu if çalıştığında diğer kodlar 0 lanıyor

            }
            if(tahmin<rastgeleSayi){
                binding.textViewYardim.text = "ARTTIR"
                binding.textViewHak.text = "Kalan Hak: $sayac"

            }
            if(tahmin>rastgeleSayi){
                binding.textViewYardim.text = "AZALT"
                binding.textViewHak.text = "Kalan Hak: $sayac"

            }
            if(sayac == 0){
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                //Sayfa geçişi
                intent.putExtra("sonuc",rastgeleSayi)
                intent.putExtra("sonuc1",false)
                //Diğer sayfaya sonuç gönderme //Kaybettiniz
                finish()
                startActivity(intent)

            }

            binding.editTextSayiGir.setText("")
            //Her yenilendiğinde editTexte boş değer atadım.


        }
    }
}