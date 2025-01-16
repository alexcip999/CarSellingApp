package com.example.car_sellingapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.car_sellingapp.screens.Routes.MainRoute.SearchCars.toSearchCars

@Composable
fun SearchBar(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isEnabled: (Boolean) = true,
    height: Dp = 40.dp,
    elevation: Dp = 3.dp,
    cornerShape: Shape = RoundedCornerShape(8.dp),
    backgroundColor: Color = Color.White,
    onSearchClicked: () -> Unit = {},
    onTextChange: (String) -> Unit = {},
    navController: NavController
) {
    // var text = remember { mutableStateOf("") }
    Row(
        modifier =
            Modifier
                .height(height)
                .fillMaxWidth()
                .shadow(elevation = elevation, shape = cornerShape)
                .background(color = backgroundColor, shape = cornerShape)
                .clickable { onSearchClicked() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            modifier =
                modifier
                    .weight(5f)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
            value = text,
            onValueChange = onTextChange,
            enabled = isEnabled,
            textStyle =
                TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                ),
            decorationBox = { innerTextField ->
                if (text.isEmpty()) {
                    Text(
                        text = hint,
                        color = Color.Gray.copy(alpha = 0.5f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                innerTextField()
            },
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search,
                ),
            keyboardActions = KeyboardActions(onSearch = {
                onSearchClicked()
                navController.toSearchCars()
            }),
            singleLine = true,
        )
        Box(
            modifier =
                modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .size(40.dp)
                    .background(color = Color.Transparent, shape = CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            if (text.isEmpty()) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            } else {
                Icon(Icons.Default.Close, contentDescription = "Close")
            }
        }
    }
}
