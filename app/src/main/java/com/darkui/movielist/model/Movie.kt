package com.darkui.movielist.model

/**
 * Data class Movie - merepresentasikan satu item film dalam daftar.
 * Kotlin data class otomatis menggenerate equals(), hashCode(), toString(), dan copy().
 *
 * @param id         ID unik untuk setiap film (digunakan sebagai key)
 * @param title      Judul film
 * @param genre      Genre/kategori film
 * @param rating     Rating film (skala 0.0 - 10.0)
 * @param year       Tahun rilis
 * @param description Deskripsi singkat film
 * @param iconEmoji  Emoji sebagai pengganti gambar (kompatibel tanpa resource tambahan)
 * @param accentColor Warna aksen hex untuk card (memberikan variasi visual)
 */
data class Movie(
    val id: Int,
    val title: String,
    val genre: String,
    val rating: Float,
    val year: Int,
    val description: String,
    val iconEmoji: String,
    val accentColor: String
)
