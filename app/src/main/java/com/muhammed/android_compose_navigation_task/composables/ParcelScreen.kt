package com.muhammed.android_compose_navigation_task.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammed.android_compose_navigation_task.data.ParcelInformation
import com.muhammed.android_compose_navigation_task.ui.theme.PurpleGrey40

@Composable
fun ParcelScreen(parcel: ParcelInformation?, onGoBack: () -> Unit, modifier: Modifier = Modifier) = if (parcel != null) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Parcel Details",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = PurpleGrey40
        )
        Spacer(modifier = modifier.height(16.dp))

        Text("Parcel ID: ${parcel.parcelId}", fontSize = 18.sp)
        Text("Status: ${parcel.deliveryStatus}", fontSize = 18.sp)
        Text("ETA: ${parcel.eta}", fontSize = 18.sp)
        Text("Location: ${parcel.currentLocation}", fontSize = 18.sp)
        Button(onClick = onGoBack) {
            Text("Go Back")
        }
    }
    } else {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Parcel not found.", color = Color.Red, fontSize = 20.sp)
    }
}