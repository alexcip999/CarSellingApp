package com.example.car_sellingapp.update_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.car_sellingapp.model.AppUiState
import com.example.car_sellingapp.model.AppViewModel
import com.example.car_sellingapp.screens.Routes.MainRoute.ForgotPassword.toForgotPassword
import com.example.car_sellingapp.screens.Routes.MainRoute.Login.toLogin

@Composable
fun VerifyScreen(
    navController: NavController,
    appViewModel: AppViewModel,
    appUiState: AppUiState

){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Hey there,",
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Change your password",
                fontSize = 30.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)

            )
            Spacer(modifier = Modifier.height(64.dp))
            Text(
                text = "Enter your email for verify if your account exists. Press the button and change your password."
            )
            Spacer(modifier = Modifier.height(4.dp))
            if (appUiState.isVerifyWrong){
                Text(
                    text = appUiState.currentErrorVerify,
                    color = Color.Red
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = appViewModel.verifyEmail,
                label = {
                    Text("Email")
                },
                placeholder = {
                    Text("Enter your email")
                },
                onValueChange = { appViewModel.updateVerifyEmail(it) },
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = { appViewModel.verifyUser(navController) }
                ),
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = "")
                },
                isError = appUiState.isVerifyWrong
            )
            Spacer(modifier = Modifier.height(324.dp))
            Button(
                onClick = { appViewModel.verifyUser(navController) },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White,
                    disabledContentColor = Color.Blue,
                    disabledContainerColor = Color.Blue
                )
            ) {
                Text(
                    text = "Change your password",
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "or",
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 8.dp),
                )
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.weight(1f)
                )
            }
            TextButton(
                onClick = { navController.toLogin() },
                modifier = Modifier.align(Alignment.CenterHorizontally),
            ) {
                Text(
                    text = "Did you remember your password? Go and login",
                    color = Color.Blue
                )
            }
        }
    }
}
