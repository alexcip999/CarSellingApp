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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.car_sellingapp.R
import com.example.car_sellingapp.model.AppViewModel

@Composable
fun ForgotPasswordHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Reset Your Password",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Text(
            text = "Strong passwords include numbers, letters and punctuation marks.",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Composable
fun ForgotPasswordFields(
    currentUsername: String,
    currentNewPassword: String,
    currentConfirmPassword: String,
    onUsernameChange: (String) -> Unit,
    onNewPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    isForgotPasswordWrong: Boolean
) {
    Column {
        OutlinedTextField(
            value = currentUsername,
            onValueChange = onUsernameChange,
            label = {
                if (isForgotPasswordWrong){
                    Text("Wrong Username")
                }else{
                    Text("Username")
                }

            },
            placeholder = {
                Text("Enter your username")
            },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Acount")
            },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                ),
            isError = isForgotPasswordWrong
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = currentNewPassword,
            onValueChange = onNewPasswordChange,
            label = {
                if (isForgotPasswordWrong){
                    Text("Passwords don't match")
                }else{
                    Text("New Password")
                }
            },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text("Enter a new password")
            },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Lock")
            },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next,
                ),
            isError = isForgotPasswordWrong
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = currentConfirmPassword,
            onValueChange = onConfirmPasswordChange,
            label = {
                if (isForgotPasswordWrong){
                    Text("Passwords don't match")
                }else{
                    Text("Confirm Password")
                }

            },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text("Confirm your password")
            },
            leadingIcon = {
                Icon(Icons.Default.CheckCircle, contentDescription = "CheckCircle")
            },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
            keyboardActions =
                KeyboardActions(onDone = {
                    onKeyboardDone()
                }),
            isError = isForgotPasswordWrong
        )
    }

}

@Composable
fun ForgotPasswordFooter(onResetPassword: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = onResetPassword,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Reset Password",
            )
        }
    }
}

@Composable
fun ForgotPasswordScreen(
    navController: NavController,
    appViewModel: AppViewModel = viewModel()

) {
    val appUiState by appViewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.white),
            contentDescription = "Forgot Password",
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
                .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier =
                Modifier
                    .padding(36.dp)
                    .alpha(0.7f)
                    .clip(
                        CutCornerShape(
                            topStart = 5.dp,
                            topEnd = 5.dp,
                            bottomStart = 5.dp,
                            bottomEnd = 5.dp,
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
                ForgotPasswordHeader()
                Spacer(modifier = Modifier.height(20.dp))
                ForgotPasswordFields(
                    currentUsername = appViewModel.forgotPassUsername,
                    currentNewPassword = appViewModel.forgotPassNewPassword,
                    currentConfirmPassword = appViewModel.forgotPassConfirmPassword,
                    onUsernameChange = { appViewModel.updateForgotPassUsername(it)},
                    onConfirmPasswordChange = { appViewModel.updateForgotPassConfirmPassword(it)},
                    onNewPasswordChange = { appViewModel.updateForgotPassNewPassword(it)},
                    onKeyboardDone = {
                        appViewModel.forgotPassword(navController)
                    },
                    isForgotPasswordWrong = appUiState.isForgotPasswordWrong
                )
                Spacer(modifier = Modifier.height(20.dp))
                ForgotPasswordFooter(
                    onResetPassword = {
                        appViewModel.forgotPassword(navController)
                    },
                )
            }
        }
    }
}
