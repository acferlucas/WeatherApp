package com.example.weatherapp

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegisterPage()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RegisterPage(modifier: Modifier = Modifier) {
    val activity = LocalContext.current as? Activity

    var name by rememberSaveable {
        mutableStateOf(value = "")
    }

    var email by rememberSaveable {
        mutableStateOf(value = "")
    }

    var password by rememberSaveable {
        mutableStateOf(value = "")
    }

    var confirmPassword by rememberSaveable {
        mutableStateOf(value = "")
    }
    
    Column (modifier = modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(24.dp),
        Arrangement.SpaceAround

    ){
        Text(text = "Crie sua conta!", fontSize = 24.sp)
        
        OutlinedTextField(
            label = { Text(text = "Nome do usuário:") },
            value = name, 
            onValueChange = { name = it },
            modifier = modifier.fillMaxWidth()
        )

        OutlinedTextField(
            label = { Text(text = "e-mail do usuário:") },
            value = email,
            onValueChange = { email = it },
            modifier = modifier.fillMaxWidth()
        )

        OutlinedTextField(
            label = { Text(text = "senha do usuário:") },
            value = password,
            onValueChange = { password = it },
            modifier = modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        OutlinedTextField(
            label = { Text(text = "confirma senha:") },
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            modifier = modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Row (modifier = modifier.fillMaxWidth(), Arrangement.Center){
            Button(
                enabled = name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && password.equals(confirmPassword),
                onClick = {
                Toast.makeText(activity, "Registro ok!", Toast.LENGTH_LONG).show()
                activity?.finish()
            }) {
                Text(text = "Registrar")
            }
            Spacer(modifier = Modifier.size(12.dp))
            Button(onClick = {
                name = "";
                email = "";
                password = "";
                confirmPassword = "";
            }) {
                Text(text = "Limpar")
            }
        }
    }

}

