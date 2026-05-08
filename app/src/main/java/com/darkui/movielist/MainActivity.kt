package com.darkui.movielist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.darkui.movielist.adapter.MovieAdapter
import com.darkui.movielist.model.Movie

/**
 * MainActivity - Activity utama yang menampilkan daftar mata kuliah menggunakan RecyclerView.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup toolbar custom
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            title = ""
            elevation = 0f
        }

        // Inisialisasi view
        recyclerView = findViewById(R.id.recyclerView)
        fab = findViewById(R.id.fab)

        // Setup RecyclerView
        setupRecyclerView()

        // Setup Floating Action Button
        fab.setOnClickListener {
            recyclerView.smoothScrollToPosition(0)
            Toast.makeText(this, "顶部 - Kembali ke atas", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView() {
        val courseList = getCourseData()

        movieAdapter = MovieAdapter(courseList) { course ->
            val message = "📘 ${course.title}\nSKS: ${course.rating.toInt()} • Semester: ${course.year}"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
            setHasFixedSize(true)
        }
    }

    /**
     * Data source daftar mata kuliah Universitas Udayana
     */
    private fun getCourseData(): List<Movie> {
        return listOf(
            Movie(
                id = 1,
                title = "Statistik",
                genre = "Wajib • Dasar",
                rating = 3.0f, // Digunakan sebagai SKS
                year = 3,      // Digunakan sebagai Semester
                description = "Mempelajari konsep dasar probabilitas, distribusi, dan analisis data statistik untuk pengambilan keputusan.",
                iconEmoji = "📊",
                accentColor = "#D4A853"
            ),
            Movie(
                id = 2,
                title = "Keamanan Informasi",
                genre = "Wajib • Keamanan",
                rating = 3.0f,
                year = 5,
                description = "Fokus pada perlindungan sistem informasi dari akses, penggunaan, pengungkapan, gangguan, atau modifikasi yang tidak sah.",
                iconEmoji = "🔐",
                accentColor = "#FF6B35"
            ),
            Movie(
                id = 3,
                title = "Sistem Enterprise",
                genre = "Wajib • Manajemen",
                rating = 3.0f,
                year = 5,
                description = "Mempelajari arsitektur dan integrasi proses bisnis dalam skala organisasi besar menggunakan sistem ERP.",
                iconEmoji = "🏢",
                accentColor = "#4A90D9"
            ),
            Movie(
                id = 4,
                title = "Integrasi dan Migrasi Sistem",
                genre = "Wajib • Teknis",
                rating = 3.0f,
                year = 5,
                description = "Metode untuk menghubungkan berbagai subsistem komputer dan aplikasi perangkat lunak agar bekerja sebagai satu kesatuan.",
                iconEmoji = "🔄",
                accentColor = "#00D4FF"
            ),
            Movie(
                id = 5,
                title = "Sistem Temu Kembali Informasi",
                genre = "Wajib • Data",
                rating = 3.0f,
                year = 5,
                description = "Studi tentang perolehan sumber daya informasi yang relevan dengan kebutuhan informasi dari koleksi sumber daya tersebut.",
                iconEmoji = "🔍",
                accentColor = "#7B68EE"
            ),
            Movie(
                id = 6,
                title = "Analisis dan Disain Sistem Informasi",
                genre = "Wajib • Pengembangan",
                rating = 4.0f,
                year = 3,
                description = "Proses pengembangan sistem informasi yang efektif melalui tahapan analisis kebutuhan dan perancangan teknis.",
                iconEmoji = "📝",
                accentColor = "#FF4081"
            ),
            Movie(
                id = 7,
                title = "Pemrograman Mobile",
                genre = "Pilihan • Pengembangan",
                rating = 3.0f,
                year = 5,
                description = "Pengembangan aplikasi untuk perangkat mobile (Android/iOS) menggunakan teknologi modern dan best practices.",
                iconEmoji = "📱",
                accentColor = "#69F0AE"
            ),
            Movie(
                id = 8,
                title = "Etika Profesi dan Pendidikan anti Korupsi",
                genre = "Wajib • Umum",
                rating = 2.0f,
                year = 7,
                description = "Membangun integritas moral dan pemahaman etika dalam menjalankan profesi di bidang teknologi informasi.",
                iconEmoji = "⚖️",
                accentColor = "#FF5252"
            )
        )
    }
}
