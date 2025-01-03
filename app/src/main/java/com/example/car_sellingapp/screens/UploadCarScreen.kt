package com.example.car_sellingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.car_sellingapp.R

@Composable
@Preview
fun UploadCarScreen(

){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.white),
            contentDescription = "Login",
            modifier =
            Modifier
                .fillMaxSize()
                .blur(8.dp),
            contentScale = ContentScale.Crop,
        )
    }
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        UploadCarHeader()
        Spacer(modifier = Modifier.height(12.dp))
        UploadCarFields()
    }

}

@Composable
fun UploadCarField(
    currentText: String,
    onChange: (String) -> Unit,
    label: String,
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = currentText,
            onValueChange = onChange,
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
@Preview
fun UploadCarFields(){
    Column {
        UploadCarField(
            currentText = "",
            onChange = {},
            label = "Mark"
        )
        UploadCarField(
            currentText = "",
            onChange = {},
            label = "Model"
        )
        UploadCarField(
            currentText = "",
            onChange = {},
            label = "Year"
        )
        UploadCarField(
            currentText = "",
            onChange = {},
            label = "Mileage"
        )
        UploadCarField(
            currentText = "",
            onChange = {},
            label = "Combustible"
        )
        UploadCarField(
            currentText = "",
            onChange = {},
            label = "Power"
        )
        UploadCarField(
            currentText = "",
            onChange = {},
            label = "Capacity"
        )
        UploadCarField(
            currentText = "",
            onChange = {},
            label = "Color"
        )
        UploadCarField(
            currentText = "",
            onChange = {},
            label = "Price"
        )


    }
}

@Composable
fun UploadCarHeader(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Upload a new car",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}