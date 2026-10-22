package com.example.navigasi.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TampilData(
    nama: String,
    gender: String,
    alamat: String,
    onBackBtnClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Detail Data")
                }
            )
        }
    ) { isiRuang ->

        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(24.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {

            Text("Nama lengkap: $nama")

            Spacer(modifier = Modifier.height(16.dp))

            Text("Jenis kelamin: $gender")

            Spacer(modifier = Modifier.height(16.dp))

            Text("Alamat: $alamat")

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onBackBtnClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Kembali")
            }
        }
    }
}