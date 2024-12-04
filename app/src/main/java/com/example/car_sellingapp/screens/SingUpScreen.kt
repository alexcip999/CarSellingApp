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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.car_sellingapp.R
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
fun SignUpScreen(navController: NavController) {
    val scrollState = rememberScrollState()

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
                val name = remember { mutableStateOf("") }
                val email = remember { mutableStateOf("") }
                val password = remember { mutableStateOf("") }

                SignUpHeader()
                Spacer(modifier = Modifier.height(20.dp))
                SignUpFields(
                    email = email.value,
                    password = password.value,
                    name = name.value,
                    onEmailChange = { email.value = it },
                    onPasswordChange = { password.value = it },
                    onNameChange = { name.value = it },
                )
                Spacer(modifier = Modifier.height(10.dp))
                SignUpFooter(
                    onSignUpClick = {
                        navController.toHome()
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
    email: String,
    password: String,
    name: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
) {
    Column {
        TextField(
            value = name,
            onValueChange = onNameChange,
            label = {
                Text("Name")
            },
            placeholder = {
                Text("Enter your name")
            },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Name")
            },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                ),
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = email,
            label = {
                Text("Email")
            },
            placeholder = {
                Text("Enter your email")
            },
            onValueChange = onEmailChange,
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = password,
            label = {
                Text("Password")
            },
            placeholder = {
                Text("Enter your password")
            },
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Go,
                ),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password")
            },
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
