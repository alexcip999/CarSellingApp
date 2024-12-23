package com.example.car_sellingapp

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.example.car_sellingapp.model.AppViewModel
import com.example.car_sellingapp.screens.Routes.MainRoute.ForgotPassword.toForgotPassword
import com.example.car_sellingapp.screens.Routes.MainRoute.SignUp.toSignUp

@Composable
fun LoginHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome Back",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Text(
            text = "Sign in to continue",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Composable
fun LoginFields(
    currentUsername: String,
    currentPassword: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    onKeyboardDone: () -> Unit,
    isLoginWrong: Boolean
) {
    Column {
        OutlinedTextField(
            value = currentUsername,
            onValueChange = onUsernameChange,
            label = {
                if (isLoginWrong){
                    Text("Wrong Username or Password")
                }else{
                    Text("Username")
                }
            },
            placeholder = {
                Text("Enter your username")
            },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Username")
            },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                ),
            isError = isLoginWrong
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = currentPassword,
            label = {
                if (isLoginWrong){
                    Text("Wrong Password or Password")
                }else{
                    Text("Password")
                }

            },
            placeholder = {
                Text("Enter your password")
            },
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
            keyboardActions = KeyboardActions(
                onDone = { onKeyboardDone() }
            ),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password")
            },
            isError = isLoginWrong
        )
        TextButton(
            onClick = onForgotPasswordClick,
            modifier = Modifier.align(Alignment.End),
        ) {
            Text(text = "Forgot Password?")
        }
    }
}

@Composable
fun LoginFooter(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = onSignInClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Sign In",
            )
        }
        TextButton(
            onClick = onSignUpClick,
        ) {
            Text(
                text = "Don't have an account, click here",
            )
        }
    }
}

@Composable
fun LoginScreen(
    navController: NavController,
    appViewModel: AppViewModel = viewModel()
) {
    val scrollState = rememberScrollState()
    val appUiState by appViewModel.uiState.collectAsState()


    Box(modifier = Modifier.fillMaxSize()) {
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

                LoginHeader()
                Spacer(modifier = Modifier.height(20.dp))
                LoginFields(
                    currentUsername = appViewModel.loginUsername,
                    currentPassword = appViewModel.loginPassword,
                    onUsernameChange = { appViewModel.updateLoginUsername(it)},
                    onPasswordChange = {appViewModel.updateLoginPassword(it)},
                    onForgotPasswordClick = {
                        navController.toForgotPassword()
                    },
                    onKeyboardDone = {
                        appViewModel.loginUser(navController)
                    },
                    isLoginWrong = appUiState.isLoginWrong
                )


                LoginFooter(
                    onSignInClick = {
                        appViewModel.loginUser(navController)
                    },
                    onSignUpClick = {
                        navController.toSignUp()
                    },
                )
            }
        }
    }
}
