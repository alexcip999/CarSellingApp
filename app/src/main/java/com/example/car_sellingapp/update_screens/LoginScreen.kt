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
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.car_sellingapp.R
import com.example.car_sellingapp.model.AppUiState
import com.example.car_sellingapp.model.AppViewModel
import com.example.car_sellingapp.screens.Routes.MainRoute.ForgotPassword.toForgotPassword
import com.example.car_sellingapp.screens.Routes.MainRoute.Home.toHome
import com.example.car_sellingapp.screens.Routes.MainRoute.Login.toLogin
import com.example.car_sellingapp.screens.Routes.MainRoute.SignUp.toSignUp
import com.example.car_sellingapp.screens.Routes.MainRoute.Verify.toVerify

@Composable
fun LoginScreen(
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
                text = "Welcome Back",
                fontSize = 30.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)

            )

            Spacer(modifier = Modifier.height(64.dp))
            if (appUiState.isLoginWrong){
                Text(
                    text = appUiState.currentErrorLogin,
                    color = Color.Red
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = appViewModel.loginEmail,
                onValueChange = { appViewModel.updateLoginEmail(it) },
                label = {
                    Text("Email")
                },
                placeholder = {
                    Text("Enter your email")
                },
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {}
                ),
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = "")
                },
                isError = appUiState.isLoginEmailWrong
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = appViewModel.loginPassword,
                onValueChange = { appViewModel.updateLoginPassword(it) },
                label = {
                    Text("Password")
                },
                placeholder = {
                    Text("Enter your password")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = { appViewModel.loginUser(navController) }
                ),
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "")
                },
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.visibility_off_24dp_e8eaed_fill0_wght400_grad0_opsz24), contentDescription = null)
                },
                isError = appUiState.isLoginPassWrong
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(
                onClick = { navController.toVerify() },
                modifier = Modifier.align(Alignment.CenterHorizontally),
            ) {
                Text(
                    text = "Forgot your password?",
                    color = Color.Blue
                )
            }
            Spacer(modifier = Modifier.height(256.dp))
            Button(
                onClick = { appViewModel.loginUser(navController) },
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
                    text = "Login",
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
                onClick = { navController.toSignUp() },
                modifier = Modifier.align(Alignment.CenterHorizontally),
            ) {
                Text(
                    text = "Don't have an account yet? Register",
                    color = Color.Blue
                )
            }
        }
    }
}

