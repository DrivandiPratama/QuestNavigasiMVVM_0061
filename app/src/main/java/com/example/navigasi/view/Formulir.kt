package com.example.navigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun FormIsian(
    onSubmitBtnClick: (String, String, String) -> Unit
) {
    val nama = remember { mutableStateOf("") }
    val gender = remember { mutableStateOf("") }
    val alamat = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Formulir")
                }
            )
        }
    ) { isiRuang ->

        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nama.value,
                onValueChange = {
                    nama.value = it
                },
                label = {
                    Text("Nama lengkap")
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = gender.value == "Laki-laki",
                    onClick = {
                        gender.value = "Laki-laki"
                    }
                )

                Text("Laki-laki")

                Spacer(modifier = Modifier.width(16.dp))

                RadioButton(
                    selected = gender.value == "Perempuan",
                    onClick = {
                        gender.value = "Perempuan"
                    }
                )

                Text("Perempuan")
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = alamat.value,
                onValueChange = {
                    alamat.value = it
                },
                label = {
                    Text("Alamat")
                },
                modifier = Modifier.fillMaxWidth(),
                minLines = 2
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    onSubmitBtnClick(
                        nama.value,
                        gender.value,
                        alamat.value
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }
}