package com.example.advocate

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_logged_in.*

class LoggedIn : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        btnRecommendations.setOnClickListener {
          val intent = Intent  (this, MainActivity2::class.java)
            startActivity(intent)
        }

        btnProfile.setOnClickListener {
            val intent = Intent  (this, Profile::class.java)
            startActivity(intent)
        }

        btnMaps.setOnClickListener {
            val intent = Intent  (this, MapsActivity::class.java)
            startActivity(intent)
        }

        btnPayement.setOnClickListener {
            val intent = Intent  (this, Payement::class.java)
            startActivity(intent)
        }

        btnMovies.setOnClickListener {
            val intent = Intent  (this, Movies::class.java)
            startActivity(intent)
        }


        val sharedPref=this?.getPreferences(Context.MODE_PRIVATE)?:return
        val isLogin=sharedPref.getString("Email","1")
        logout.setOnClickListener {
            sharedPref.edit().remove("Email").apply()
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}