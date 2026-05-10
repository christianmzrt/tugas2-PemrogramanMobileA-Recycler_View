# UNUDHub — Academic Modern UI Android App

Aplikasi Android dengan tampilan **Dark Modern UI** yang menampilkan daftar mata kuliah Universitas Udayana menggunakan `RecyclerView`, dibangun dengan **Kotlin** dan **Material Design 3**.

---

## Identitas

| Keterangan | Detail |
|------------|--------|
| **Nama** | Richard Christian Mozart Diazoni |
| **NIM** | 2405551019 |
| **Kelas** | Pemrograman Mobile A |

---

## Struktur Project

```
UNUDHub/
├── app/
│   ├── src/main/
│   │   ├── java/com/darkui/movielist/
│   │   │   ├── model/
│   │   │   │   └── Movie.kt              ← Data class (digunakan untuk Mata Kuliah)
│   │   │   ├── adapter/
│   │   │   │   └── MovieAdapter.kt       ← RecyclerView Adapter + ViewHolder
│   │   │   ├── SplashActivity.kt         ← Layar pembuka dengan identitas
│   │   │   └── MainActivity.kt           ← Activity utama (Daftar Matkul)
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_splash.xml   ← Layout splash (Logo + Identitas)
│   │   │   │   ├── activity_main.xml     ← Layout utama (RecyclerView)
│   │   │   │   └── item_movie.xml        ← Layout satu item card matkul
│   │   │   ├── values/
│   │   │   │   ├── colors.xml            ← Palet warna dark modern
│   │   │   │   ├── strings.xml           ← String resources & data identitas
│   │   │   │   └── themes.xml            ← Dark tema Material3
│   │   │   └── drawable/
│   │   │       ├── splash_glow.xml       ← Efek glow radial
│   │   │       └── ic_launcher_...       ← Adaptive Icon 
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
└── settings.gradle
```
---


## Desain UI

### Palet Warna Dark Modern

| Elemen | Warna Hex | Fungsi |
|--------|-----------|--------|
| Background | `#0A0A0F` | Latar belakang utama |
| AppBar | `#0D0D14` | Toolbar/header UNUDHub |
| Card | `#12121C` | Background card mata kuliah |
| Teks Utama | `#F1F1F5` | Nama Mata Kuliah |
| Aksen Neon | `#00D4FF` | SKS, FAB, Identitas NIM |

---

## Penjelasan Setiap File

### 1. `Movie.kt` — Data Class
Meskipun bernama *Movie*, class ini digunakan untuk menyimpan data Mata Kuliah seperti Nama Matkul, SKS (Rating), Semester (Year), dan Deskripsi.

### 2. `MovieAdapter.kt` — RecyclerView Adapter
Mengelola tampilan daftar mata kuliah dengan animasi *staggered* (muncul satu per satu dari bawah).

### 3. `SplashActivity.kt` — Splash Screen
Menampilkan logo dan identitas lengkap (Nama, NIM, Kelas) selama 3 detik sebelum masuk ke dashboard utama.

### 4. `MainActivity.kt` — Dashboard UNUDHub
Menyediakan data 8 mata kuliah pilihan:

| No. | Mata Kuliah |
|-----|-------------|
| 1 | Statistik |
| 2 | Keamanan Informasi |
| 3 | Sistem Enterprise |
| 4 | Integrasi dan Migrasi Sistem |
| 5 | Sistem Temu Kembali Informasi |
| 6 | Analisis dan Disain Sistem Informasi |
| 7 | Pemrograman Mobile |
| 8 | Etika Profesi dan Pendidikan Anti Korupsi |

---

## Fitur yang Diimplementasikan

- [x] **Branding Baru** — Nama aplikasi berubah menjadi *UNUDHub* dengan ikon 
- [x] **Identitas Mahasiswa** — Nama, NIM, dan Kelas muncul di *Splash Screen*
- [x] **RecyclerView** — Menampilkan daftar mata kuliah dengan lancar
- [x] **Custom Data** — Data film diganti menjadi data akademik (SKS & Semester)
- [x] **Adaptive Icon** — Memperbaiki error resource dengan membuat ikon adaptif baru
- [x] **Dark Modern UI** — Desain premium berbasis Material Design 3
- [x] **Floating Action Button** — Fitur *scroll to top* dengan animasi

---

## Cara Menjalankan Project

1. Buka **Android Studio**
2. Pilih **Sync Gradle** dan tunggu hingga selesai
3. Jalankan aplikasi
4. Pastikan menggunakan **Emulator atau Device** dengan minimal **API 24 (Android 7.0)**

---

> *Dibuat untuk Tugas Pemrograman Mobile A — Universitas Udayana*
