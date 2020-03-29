package com.greedyassignment.helper

import android.content.Context
import android.widget.Toast

class Globals {

    companion object {
        fun showToastMessage(context: Context, message: String) =
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}