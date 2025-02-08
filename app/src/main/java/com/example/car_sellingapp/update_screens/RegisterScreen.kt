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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
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
import com.example.car_sellingapp.screens.Routes.MainRoute.Login.toLogin
import com.example.car_sellingapp.screens.Routes.MainRoute.PopUpRegister.toPopUpRegister

@Composable
fun RegisterScreen(
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
                text = "Create an Account",
                fontSize = 30.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)

            )
            Spacer(modifier = Modifier.height(64.dp))
            if (appUiState.isRegisterWrong){
                Text(
                    text = appUiState.currentErrorRegister,
                    color = Color.Red
                )
            }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = appViewModel.registerName,
                onValueChange = { appViewModel.updateRegisterName(it) },
                label = {
                    Text("Name")
                },
                placeholder = {
                    Text("Enter your name")
                },
                keyboardOptions =
                    KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next,
                    ),
                keyboardActions =
                    KeyboardActions(
                        onDone = {}
                    ),
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "")
                },
                isError = appUiState.isRegisterNameWrong
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = appViewModel.registerEmail,
                onValueChange = { appViewModel.updateRegisterEmail(it) },
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
                isError = appUiState.isRegisterEmailWrong || appUiState.isRegisterEmailInvalid
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = appViewModel.registerPassword,
                onValueChange = { appViewModel.updateRegisterPassword(it) },
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
                    imeAction = ImeAction.Next,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {}
                ),
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.visibility_off_24dp_e8eaed_fill0_wght400_grad0_opsz24), contentDescription = null)
                },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "")
                },
                isError = appUiState.isRegisterPasswordsWrong
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = appViewModel.registerPasswordConfirmation,
                onValueChange = { appViewModel.updateRegisterPasswordConfirmation(it) },
                label = {
                    Text("Confirm Password")
                },
                placeholder = {
                    Text("Confirm password")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = { appViewModel.registerUser(navController) }
                ),
                leadingIcon = {
                    Icon(Icons.Default.Check, contentDescription = "")
                },
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.visibility_off_24dp_e8eaed_fill0_wght400_grad0_opsz24), contentDescription = null)
                },
                isError = appUiState.isRegisterPasswordsWrong
            )
            Spacer(modifier = Modifier.height(150.dp))
            Button(
                onClick = { appViewModel.registerUser(navController) },
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
                    text = "Register",
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
                    text = "Already have an account? Login",
                    color = Color.Blue
                )
            }
        }
    }
}
