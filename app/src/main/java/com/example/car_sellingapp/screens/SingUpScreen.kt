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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.car_sellingapp.screens.Routes.MainRoute.Home.toHome
import com.example.car_sellingapp.screens.Routes.MainRoute.Login.toLogin


@Composable
fun SignUpHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Text(
            text = "Sign up to continue",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Composable
fun SignUpScreen(
    navController: NavController,
    appViewModel: AppViewModel = viewModel()
) {
    val scrollState = rememberScrollState()
    val appUiState by appViewModel.uiState.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.white),
            contentDescription = "SignUp",
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
                SignUpHeader()
                Spacer(modifier = Modifier.height(20.dp))
                SignUpFields(
                    currentUsername = appViewModel.registerUsername,
                    currentPassword = appViewModel.registerPassword,
                    currentPasswordConfirmation = appViewModel.registerPasswordConfirmation,
                    onUsernameChange = { appViewModel.updateRegisterUsername(it) },
                    onPasswordChange = { appViewModel.updateRegisterPassword(it) },
                    onPasswordConfirmationChange = { appViewModel.updateRegisterPasswordConfirmation(it) },
                    onKeyboardDone = {
                        appViewModel.registerUser(navController)
                    },
                    isRegisterWrong = appUiState.isRegisterWrong
                )

                Spacer(modifier = Modifier.height(10.dp))
                SignUpFooter(
                    onSignUpClick = {
                        appViewModel.registerUser(navController)
                    },
                    onSignInClick = {
                        navController.toLogin()
                    },
                )
            }
        }
    }
}



@Composable
fun SignUpFields(
    currentUsername: String,
    currentPassword: String,
    currentPasswordConfirmation: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordConfirmationChange: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    isRegisterWrong: Boolean
) {

    Column {
        OutlinedTextField(
            value = currentUsername,
            onValueChange = onUsernameChange,
            label = {
                if (isRegisterWrong){
                    Text("Username exists or passwords don't match")
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
            isError = isRegisterWrong
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = currentPassword,
            label = {
                if (isRegisterWrong){
                    Text("Username exists or passwords don't match")
                }else{
                    Text("Password")
                }
            },
            placeholder = {
                Text("Enter your password")
            },
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password")
            },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next,
                ),
            isError = isRegisterWrong
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = currentPasswordConfirmation,
            label = {
                if (isRegisterWrong){
                    Text("Username exists or passwords don't match")
                }else{
                    Text("Confirm Password")
                }
            },
            placeholder = {
                Text("Repeat your password")
            },
            onValueChange = onPasswordConfirmationChange,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
            keyboardActions =
                KeyboardActions(onDone = {
                    onKeyboardDone()
                }),
            leadingIcon = {
                Icon(Icons.Default.Check, contentDescription = "Confirmation Password")
            },
            isError = isRegisterWrong
        )
    }
}

@Composable
fun SignUpFooter(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = onSignUpClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Sing Up",
            )
        }
        TextButton(
            onClick = onSignInClick,
        ) {
            Text(
                text = "Already have an account? Log In",
            )
        }
    }
}
