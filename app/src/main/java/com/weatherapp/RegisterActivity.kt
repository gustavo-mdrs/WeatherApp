package com.weatherapp

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weatherapp.ui.theme.WeatherAppTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterPage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPage(modifier: Modifier = Modifier) {
    var usuario by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordConfirm by rememberSaveable { mutableStateOf("") }
    val activity = LocalActivity.current as Activity
    Column(
        modifier = modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Bem-vindo/a!",
            fontSize = 24.sp
        )

        OutlinedTextField(
            value = usuario,
            label = { Text(text = "Digite seu nome de usuário") },
            modifier = modifier.fillMaxWidth(fraction = 0.9f),
            onValueChange = { usuario = it }
        )

        Spacer(modifier = modifier.size(10.dp))

        OutlinedTextField(
            value = email,
            label = { Text(text = "Digite seu e-mail") },
            modifier = modifier.fillMaxWidth(fraction = 0.9f),
            onValueChange = { email = it }
        )

        Spacer(modifier = modifier.size(10.dp))

        OutlinedTextField(
            value = password,
            label = { Text(text = "Digite sua senha") },
            modifier = modifier.fillMaxWidth(fraction = 0.9f),
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = modifier.size(10.dp))

        OutlinedTextField(
            value = passwordConfirm,
            label = { Text(text = "Digite sua senha novamente") },
            modifier = modifier.fillMaxWidth(fraction = 0.9f),
            onValueChange = { passwordConfirm = it },
            visualTransformation = PasswordVisualTransformation()
        )
        Row(modifier = modifier) {
            Button(onClick = {
                Toast.makeText(activity, "Registrado com sucesso!", Toast.LENGTH_LONG).show()
                activity.finish()
            },enabled = email.isNotEmpty()&& usuario.isNotEmpty() && passwordConfirm.isNotEmpty() && password.isNotEmpty() && password == passwordConfirm) {
                Text("Registrar")
            }
            Button(
                onClick = { email = ""; password = ""; usuario = ""; passwordConfirm = "" }
            ) {
                Text("Limpar")
            }
        }
    }
}
