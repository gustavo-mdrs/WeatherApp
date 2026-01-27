package com.weatherapp.ui.theme

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.weatherapp.MainViewModel
import com.weatherapp.R
import com.weatherapp.model.City
import com.weatherapp.model.Weather
import com.weatherapp.ui.theme.nav.Route

@Composable
fun ListPage(modifier: Modifier = Modifier, viewModel: MainViewModel) {

    val cityList = viewModel.cities
    val activity = LocalActivity.current as Activity

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(items = cityList, key = { it.name }) { city ->
            CityItem(
                city = city,
                weather = viewModel.weather(city.name),
                onClose = {
                    viewModel.remove(city)
                },
                onClick = {
                    viewModel.city = city.name
                    viewModel.page = Route.Home
                }
            )
        }
    }
}

@Composable
fun CityItem(
    city: City,
    weather: Weather,
    onClick: () -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    val desc =
        if (weather == Weather.LOADING) "Carregando clima..." else weather.desc

    val icon =
        if (city.isMonitored)
            Icons.Filled.Notifications
        else
            Icons.Outlined.Notifications

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = weather.imgUrl,
            modifier = Modifier.size(75.dp),
            error = painterResource(id = R.drawable.loading),
            contentDescription = "Imagem"
        )

        Spacer(modifier = Modifier.size(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = city.name,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.size(8.dp))
                Icon(
                    imageVector = icon,
                    contentDescription = "Monitorada"
                )
            }

            Text(
                text = desc,
                fontSize = 16.sp
            )
        }

        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}
