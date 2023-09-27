package com.example.sayiuretme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sayiuretme.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity(R.layout.activity_sonuc) {
    private lateinit var binding:ActivitySonucBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val alinanDeger = intent.getIntExtra("sonuc",0)
        val deger = intent.getBooleanExtra("sonuc1",false)
        //Veriyi doğru gönderemezsek false dönecek.

        if(alinanDeger != 0 && deger){
            binding.textViewSonuc.text = "KAZANDINIZ"
            binding.imageView2.setImageResource(R.drawable.mutlu_resim)
            binding.textViewSayi.text = "SAYI: $alinanDeger"
        }
        else{
            binding.textViewSonuc.text = "KAYBETTİNİZ"
            binding.imageView2.setImageResource(R.drawable.uzgun_resim)
            binding.textViewSayi.text = "SAYI: $alinanDeger"
        }

        binding.buttonTekrar.setOnClickListener{
            val intent = Intent(this@SonucActivity,MainActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}