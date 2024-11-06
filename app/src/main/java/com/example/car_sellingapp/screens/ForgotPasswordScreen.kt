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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.car_sellingapp.screens.Routes.MainRoute.Login.toLogin

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
    newPassword: String,
    confirmPassword: String,
    onNewPasswordChange: (String) -> Unit,
    onConfirmPassword: (String) -> Unit,
) {
    TextField(
        value = newPassword,
        onValueChange = onNewPasswordChange,
        label = {
            Text("New Password")
        },
        placeholder = {
            Text("Enter your new password")
        },
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = "Lock")
        },
        keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next,
            ),
    )
    Spacer(modifier = Modifier.height(10.dp))
    TextField(
        value = newPassword,
        onValueChange = onNewPasswordChange,
        label = {
            Text("Confirm Password")
        },
        placeholder = {
            Text("Confirm your password")
        },
        leadingIcon = {
            Icon(Icons.Default.CheckCircle, contentDescription = "CheckCircle")
        },
        keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Go,
            ),
    )
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
fun ForgotPasswordScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
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
                val newPassword = remember { mutableStateOf("") }
                val confirmPassword = remember { mutableStateOf("") }

                ForgotPasswordHeader()
                Spacer(modifier = Modifier.height(20.dp))
                ForgotPasswordFields(
                    newPassword = newPassword.value,
                    confirmPassword = confirmPassword.value,
                    onConfirmPassword = { confirmPassword.value = it },
                    onNewPasswordChange = { newPassword.value = it },
                )
                Spacer(modifier = Modifier.height(20.dp))
                ForgotPasswordFooter(
                    onResetPassword = {
                        navController.toLogin()
                    },
                )
            }
        }
    }
}
