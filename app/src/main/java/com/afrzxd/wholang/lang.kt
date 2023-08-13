package com.afrzxd.wholang

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Lang(
    val name: String,
    val tahun: String,
    val since: String,
    val owner: String,
    val description: String,
    val photo: Int
): Parcelable