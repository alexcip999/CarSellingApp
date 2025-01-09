package com.example.car_sellingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.car_sellingapp.R
import com.example.car_sellingapp.model.AppUiState
import com.example.car_sellingapp.model.AppViewModel


@Composable
fun UpdateDetailsAboutUserScreen(
    navController: NavController,
    appViewModel: AppViewModel,
    appUiState: AppUiState
){
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.white),
            contentDescription = "Update Data",
            modifier =
            Modifier
                .fillMaxSize()
                .blur(8.dp),
            contentScale = ContentScale.Crop,
        )
    }

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier =
            Modifier
                .padding(28.dp)
                .alpha(0.7f)
                .clip(
                    CutCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp,
                    ),
                ).background(MaterialTheme.colorScheme.background)
                .wrapContentHeight(),
        ) {
            Column(
                modifier =
                Modifier
                    .padding(48.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                UpdateHeader()
                Spacer(modifier = Modifier.height(20.dp))
                UpdateFields(
                    currentName = appViewModel.dataName,
                    currentCountry = appViewModel.dataCountry,
                    currentCity = appViewModel.dataCity,
                    currentPhone = appViewModel.dataPhone,
                    onNameChange = { appViewModel.updateDataName(it) },
                    onCityChange = { appViewModel.updateDataCity(it) },
                    onPhoneChange = { appViewModel.updateDataPhone(it) },
                    onCountryChange = { appViewModel.updateDataCountry(it) },
                    isUpdateWrong = appUiState.isUpdateWrong
                )


                UpdateFooter(
                    onSaveClick = { appViewModel.saveDetailsAboutUser(navController) }
                )
            }
        }
    }
}

@Composable
fun UpdateHeader(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Update info about you",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
        )
    }
}

@Composable
fun UpdateFields(
    currentName: String,
    currentCountry: String,
    currentCity: String,
    currentPhone: String,
    onNameChange: (String) -> Unit,
    onCountryChange: (String) -> Unit,
    onCityChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    isUpdateWrong: Boolean
){
    OutlinedTextField(
        value = currentName,
        onValueChange = onNameChange,
        label = {
            if (isUpdateWrong){
                Text("Empty field")
            }else{
                Text("Name")
            }
        },
        placeholder = {
            Text("Enter your name")
        },
        keyboardOptions =
        KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
        isError = isUpdateWrong
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = currentCountry,
        onValueChange = onCountryChange,
        label = {
            if (isUpdateWrong){
                Text("Empty field")
            }else{
                Text("Country")
            }
        },
        placeholder = {
            Text("Enter your country")
        },
        keyboardOptions =
        KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
        isError = isUpdateWrong
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = currentCity,
        onValueChange = onCityChange,
        label = {
            if (isUpdateWrong){
                Text("Empty field")
            }else{
                Text("City")
            }
        },
        placeholder = {
            Text("Enter your City")
        },
        keyboardOptions =
        KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
        isError = isUpdateWrong
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = currentPhone,
        onValueChange = onPhoneChange,
        label = {
            if (isUpdateWrong){
                Text("Empty field")
            }else{
                Text("Phone number")
            }
        },
        placeholder = {
            Text("Enter your phone number")
        },
        keyboardOptions =
        KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
        isError = isUpdateWrong
    )
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun UpdateFooter(
    onSaveClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = onSaveClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Save",
            )
        }
    }
}