package com.example.car_sellingapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.car_sellingapp.data.remote.dto.CarDTO
import com.example.car_sellingapp.model.AppUiState
import com.example.car_sellingapp.model.AppViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CardSlider(
    cards: List<CarDTO>,
    navController: NavController,
    appViewModel: AppViewModel,
    appUiState: AppUiState
) {
    var currentCardIndex by remember { mutableStateOf(0) }
    var isAnimating by remember { mutableStateOf(false) }
    var coroutineScope = rememberCoroutineScope()

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(cards) { index, card ->
            Card(
                modifier =
                    Modifier
                        .width(330.dp)
                        .height(300.dp)
                        .clickable {
                            if (index != currentCardIndex && !isAnimating) {
                                isAnimating = true
                                coroutineScope.launch {
                                    val delayMillis = 500L
                                    delay(delayMillis / 2)
                                    currentCardIndex = index
                                    delay(delayMillis)
                                    isAnimating = false
                                }
                            }
                        },
            ) {
                CarCard(card, navController, appViewModel, appUiState)
            }
        }
    }
}
