package com.example.navigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasi.ui.view.TampilData
import com.example.navigasi.view.FormIsian

enum class Navigasi {
    FormulirSaya,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    val nama = remember { mutableStateOf("") }
    val gender = remember { mutableStateOf("") }
    val alamat = remember { mutableStateOf("") }

    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.FormulirSaya.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(route = Navigasi.FormulirSaya.name) {
                FormIsian(
                    onSubmitBtnClick = { namaInput, genderInput, alamatInput ->
                        nama.value = namaInput
                        gender.value = genderInput
                        alamat.value = alamatInput

                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            composable(route = Navigasi.Detail.name) {
                TampilData(
                    nama = nama.value,
                    gender = gender.value,
                    alamat = alamat.value,
                    onBackBtnClick = {
                        navController.popBackStack(
                            Navigasi.FormulirSaya.name,
                            inclusive = false
                        )
                    }
                )
            }
        }
    }
}