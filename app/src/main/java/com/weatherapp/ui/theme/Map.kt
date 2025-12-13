package com.weatherapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.weatherapp.MainViewModel

@Preview(showBackground = true)
@Composable
fun MapPage(modifier: Modifier = Modifier.Companion, viewModel: MainViewModel) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(Color.Companion.Gray)
            .wrapContentSize(Alignment.Companion.Center)
    ) {
        Text(
            text = "Mapa",
            fontWeight = FontWeight.Companion.Bold,
            color = Color.Companion.White,
            modifier = modifier.align(Alignment.Companion.CenterHorizontally),
            textAlign = TextAlign.Companion.Center,
            fontSize = 20.sp
        )
    }
}