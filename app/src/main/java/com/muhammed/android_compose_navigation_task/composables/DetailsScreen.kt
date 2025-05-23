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
    fun DetailsScreen(parcel: ParcelInformation?,
                      modifier: Modifier = Modifier,
                      onBackHome: () -> Unit,
                      onViewParcelInfo: (ParcelInformation) -> Unit) {
        if (parcel != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Your parcel is currently in ${parcel.currentLocation}.",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(24.dp))

                Button(onClick = {onViewParcelInfo(parcel)}) {
                    Text("View Parcel Info")
                }

                Spacer(Modifier.height(16.dp))

                Button(onClick = onBackHome) {
                    Text("Back to Home")
                }
            }
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Parcel not found.", color = Color.Red, fontSize = 20.sp)
            }
        }
    }
