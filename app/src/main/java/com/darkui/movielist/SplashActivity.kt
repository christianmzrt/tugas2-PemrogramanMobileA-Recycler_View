package com.darkui.movielist

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * SplashActivity - Layar pembuka aplikasi.
 *
 * Menampilkan logo, nama aplikasi, dan identitas pengembang selama 3 detik,
 * kemudian berpindah ke MainActivity secara otomatis.
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Sembunyikan action bar bawaan di splash screen
        supportActionBar?.hide()

        // Referensi ke view untuk animasi
        val logoView = findViewById<TextView>(R.id.tvSplashLogo)
        val titleView = findViewById<TextView>(R.id.tvSplashTitle)
        val subtitleView = findViewById<TextView>(R.id.tvSplashSubtitle)
        val identityContainer = findViewById<View>(R.id.identityContainer)

        // Muat animasi
        val fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        val slideUp = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        
        // Animasi fade in untuk identitas agar muncul perlahan
        val slowFadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in).apply {
            duration = 1500
        }

        // Terapkan animasi ke elemen splash
        logoView.startAnimation(fadeIn)
        titleView.startAnimation(slideUp)
        subtitleView.startAnimation(fadeIn)
        identityContainer.startAnimation(slowFadeIn)

        // Pindah ke MainActivity setelah 3000ms (3 detik) agar identitas terbaca
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            // Animasi transisi antar activity
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 3000)
    }
}
