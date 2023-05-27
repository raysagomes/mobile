package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.empregaeu4.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.DatabaseReference



class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idNome = binding.edUsuario
        val btLogin = binding.btLogin
        val idSenha = binding.idSenha
        val btSignup = binding.btSignup


        btLogin.setOnClickListener {

            if (idSenha != null) {
                if(idNome.text.toString() == "Raysa" && idSenha.text.toString().toIntOrNull() == 157) {
                    val intent = Intent(this, Tela2Activity::class.java)
                    val texto = idNome.text.toString()
                    intent.putExtra("nome", texto)
                    startActivity(intent)

                    val database = Firebase.database
                    val myRef = database.getReference("message")

                    myRef.setValue("Hello, World!")

                } else {
                    Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
                }
            }
        }
        btSignup?.setOnClickListener {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }
        //setContentView(R.layout.activity_main)
    }
}
