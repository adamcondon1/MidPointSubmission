package com.x18392911.Adam.Condon.Advocate.utils

import android.content.Context
import android.widget.Toast

fun showToast(context: Context, text: String) {
    Toast.makeText(
        context,
        text,
        Toast.LENGTH_LONG
    ).show()
}
