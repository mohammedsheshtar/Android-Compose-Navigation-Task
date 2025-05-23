package com.muhammed.android_compose_navigation_task.data

import java.util.Date

data class ParcelInformation(val parcelId: Int,
                             val deliveryStatus: String,
                             val eta: Date = Date(),
                             val customerName: String,
                             val currentLocation: String)
