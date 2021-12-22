package com.x18392911.Adam.Condon.Advocate.data

data class Movie(
    val id: Int,
    val title: String,
    val genres: List<String>,
    val count: Int,
    var liked: Boolean
)