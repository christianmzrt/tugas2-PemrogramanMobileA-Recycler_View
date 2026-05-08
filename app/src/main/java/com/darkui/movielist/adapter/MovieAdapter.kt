package com.darkui.movielist.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.darkui.movielist.R
import com.darkui.movielist.model.Movie

/**
 * MovieAdapter - Adapter untuk RecyclerView yang menampilkan daftar film.
 *
 * Adapter bertanggung jawab untuk:
 * 1. Membuat ViewHolder baru (onCreateViewHolder)
 * 2. Mengikat data ke ViewHolder (onBindViewHolder)
 * 3. Mengelola jumlah item (getItemCount)
 *
 * @param movieList  List data film yang akan ditampilkan
 * @param onItemClick Lambda callback saat item diklik (mengirimkan objek Movie)
 */
class MovieAdapter(
    private val movieList: List<Movie>,
    private val onItemClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    /**
     * ViewHolder - Menyimpan referensi ke semua View dalam satu item list.
     * Pola ViewHolder mencegah pemanggilan findViewById() berulang yang mahal
     * saat RecyclerView melakukan scroll.
     *
     * @param itemView View root dari layout item_movie.xml
     */
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Referensi ke setiap widget dalam layout item
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val tvEmoji: TextView = itemView.findViewById(R.id.tvEmoji)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvGenre: TextView = itemView.findViewById(R.id.tvGenre)
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
        val tvYear: TextView = itemView.findViewById(R.id.tvYear)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val accentBar: View = itemView.findViewById(R.id.accentBar)
    }

    /**
     * Dipanggil RecyclerView saat membutuhkan ViewHolder baru.
     * Inflate layout XML dan bungkus dalam ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    /**
     * Dipanggil RecyclerView untuk mengikat data ke ViewHolder pada posisi tertentu.
     * Di sinilah data Movie dimasukkan ke tampilan visual.
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]

        // Isi data ke masing-masing view
        holder.tvEmoji.text = movie.iconEmoji
        holder.tvTitle.text = movie.title
        holder.tvGenre.text = movie.genre.uppercase()
        holder.tvRating.text = "★ ${movie.rating}"
        holder.tvYear.text = movie.year.toString()
        holder.tvDescription.text = movie.description

        // Terapkan warna aksen unik per item untuk variasi visual
        try {
            val color = Color.parseColor(movie.accentColor)
            holder.accentBar.setBackgroundColor(color)
            holder.tvRating.setTextColor(color)
        } catch (e: IllegalArgumentException) {
            // Fallback ke warna default jika hex tidak valid
            holder.accentBar.setBackgroundColor(Color.parseColor("#00D4FF"))
        }

        // Animasi masuk staggered: delay berdasarkan posisi untuk efek cascade
        holder.cardView.alpha = 0f
        holder.cardView.translationY = 60f
        holder.cardView.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(350)
            .setStartDelay((position * 80L).coerceAtMost(600L))
            .start()

        // Set listener klik pada seluruh card
        holder.cardView.setOnClickListener {
            onItemClick(movie)
        }
    }

    /**
     * Mengembalikan jumlah total item dalam list.
     * RecyclerView menggunakan ini untuk menentukan berapa ViewHolder yang diperlukan.
     */
    override fun getItemCount(): Int = movieList.size
}
