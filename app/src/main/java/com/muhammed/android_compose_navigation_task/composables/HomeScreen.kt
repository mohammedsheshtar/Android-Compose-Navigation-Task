package com.muhammed.android_compose_navigation_task.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammed.android_compose_navigation_task.R
import com.muhammed.android_compose_navigation_task.ui.theme.Blue
import com.muhammed.android_compose_navigation_task.ui.theme.PurpleGrey40
import com.muhammed.android_compose_navigation_task.ui.theme.White
import java.time.format.TextStyle

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, onClicked: (String) -> Unit = {}) {

    var parcelId by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.welcome_message),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = PurpleGrey40,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = parcelId,
            onValueChange = { parcelId = it },
            label = { Text("Enter Parcel ID") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.8f)
        )

        Button(
            onClick = { if (parcelId.isNotBlank()) onClicked(parcelId) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue,
                contentColor = White
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.buttonElevation(8.dp)
        ) {
            Text(
                text = "Track Parcel",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

    }
}