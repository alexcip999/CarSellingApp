package com.example.car_sellingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.car_sellingapp.R
import com.example.car_sellingapp.data.remote.dto.CombustibleType
import com.example.car_sellingapp.model.AppUiState
import com.example.car_sellingapp.model.AppViewModel

@Composable
fun UploadCarScreen(
    navController: NavController,
    appViewModel: AppViewModel,
    appUiState: AppUiState
){
    val scrollState = rememberScrollState()
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
        UploadCarFields(
            scrollState = scrollState,
            currentMark = appViewModel.uploadMark,
            currentSelectedCombustibleType = appViewModel.uploadSelectedCombustibleType,
            currentColor = appViewModel.uploadColor,
            currentModel = appViewModel.uploadModel,
            currentPower = appViewModel.uploadPower,
            currentPrice = appViewModel.uploadPrice,
            currentYear = appViewModel.uploadYear,
            currentMileage = appViewModel.uploadMileage,
            currentCapacity = appViewModel.uploadCapacity,
            currentDescription = appViewModel.uploadDescription,
            onMarkChange = { appViewModel.updateUploadMark(it) },
            onYearChange = { appViewModel.updateUploadYear(it) },
            onColorChange = { appViewModel.updateUploadColor(it) },
            onModelChange = { appViewModel.updateUploadModel(it) },
            onPowerChange = { appViewModel.updateUploadPower(it) },
            onPriceChange = { appViewModel.updateUploadPrice(it) },
            onCapacityChange = { appViewModel.updateUploadCapacity(it) },
            onMileageChange = { appViewModel.updateUploadMileage(it) },
            onCombustibleTypeChange = { appViewModel.updateUploadCombustibleType(it) },
            onDescriptionChange = { appViewModel.updateUploadDescription(it) },
            onUploadClick = { appViewModel.uploadCar(navController) },
            isUploadCarWrong = appUiState.isUploadCarWrong
        )

    }

}

@Composable
fun UploadCarField(
    currentText: String,
    onChange: (String) -> Unit,
    label: String,
    isUploadCarWrong: Boolean
){
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(label)
            },
            value = currentText,
            onValueChange = onChange,
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
            isError = isUploadCarWrong
        )
        Spacer(modifier = Modifier.height(12.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadCarFields(
    scrollState: ScrollState,
    currentMark: String,
    currentModel: String,
    currentYear: String,
    currentMileage: String,
    currentSelectedCombustibleType: CombustibleType,
    currentPower: String,
    currentCapacity: String,
    currentColor: String,
    currentPrice: String,
    currentDescription: String,
    onMarkChange: (String) -> Unit,
    onModelChange: (String) -> Unit,
    onYearChange: (String) -> Unit,
    onMileageChange: (String) -> Unit,
    onCombustibleTypeChange: (CombustibleType) -> Unit,
    onPowerChange: (String) -> Unit,
    onCapacityChange: (String) -> Unit,
    onColorChange: (String) -> Unit,
    onPriceChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onUploadClick: () -> Unit,
    isUploadCarWrong: Boolean
){
    var selectedCombustible by remember { mutableStateOf(CombustibleType.GASOLINE) }
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        UploadCarField(
            currentText = currentMark,
            onChange = onMarkChange,
            label = "Mark",
            isUploadCarWrong = isUploadCarWrong
        )
        UploadCarField(
            currentText = currentModel,
            onChange = onModelChange,
            label = "Model",
            isUploadCarWrong = isUploadCarWrong
        )
        UploadCarField(
            currentText = currentYear,
            onChange = onYearChange,
            label = "Year",
            isUploadCarWrong = isUploadCarWrong
        )
        UploadCarField(
            currentText = currentMileage,
            onChange = onMileageChange,
            label = "Mileage",
            isUploadCarWrong = isUploadCarWrong
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ){
            ExposedDropdownMenuBox(
                modifier = Modifier.fillMaxWidth(),
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    value = currentSelectedCombustibleType.displayName,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Combustible Type") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    }
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    CombustibleType.values().forEach { type ->
                        DropdownMenuItem(
                            text = { Text(text = type.displayName) },
                            onClick = {
                                onCombustibleTypeChange(type)
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        UploadCarField(
            currentText = currentPower,
            onChange = onPowerChange,
            label = "Power",
            isUploadCarWrong = isUploadCarWrong
        )
        UploadCarField(
            currentText = currentCapacity,
            onChange = onCapacityChange,
            label = "Capacity",
            isUploadCarWrong = isUploadCarWrong
        )
        UploadCarField(
            currentText = currentColor,
            onChange = onColorChange,
            label = "Color",
            isUploadCarWrong = isUploadCarWrong
        )
        UploadCarField(
            currentText = currentPrice,
            onChange = onPriceChange,
            label = "Price",
            isUploadCarWrong = isUploadCarWrong
        )

        UploadCarField(
            currentText = currentDescription,
            onChange = onDescriptionChange,
            label = "Description",
            isUploadCarWrong = isUploadCarWrong
        )

        UploadCarFooter(
            onUploadClick = onUploadClick
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
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun UploadCarFooter(
    onUploadClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = onUploadClick,
        ) {
            Text(
                text = "Upload the new car",
            )
        }
    }
}
