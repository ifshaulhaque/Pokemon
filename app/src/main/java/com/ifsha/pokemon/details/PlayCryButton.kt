package com.ifsha.pokemon.details

import android.media.MediaPlayer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PlayCryButton(url: String) {
    Button(
        onClick = { 
            val mediaPlayer = MediaPlayer().apply {
                setDataSource(url)
                prepare()
                start()
            }
        }
    ) {
        Text("Play Cry")
    }
}
