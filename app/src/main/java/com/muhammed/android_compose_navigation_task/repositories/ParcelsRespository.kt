package com.muhammed.android_compose_navigation_task.repositories

import com.muhammed.android_compose_navigation_task.data.ParcelInformation
import java.util.Date

object ParcelsRepository {
    val parcels = listOf(
        ParcelInformation(301, "Delayed due to weather", Date(), "Shaikha", "London"),
        ParcelInformation(302, "Processing", Date(), "Talal", "Miami"),
        ParcelInformation(303, "Returned to Sender", Date(), "Maryam", "Riyadh"),
        ParcelInformation(304, "Delayed due to weather", Date(), "Fahad", "Chicago"),
        ParcelInformation(305, "Delivered", Date(), "Abeer", "Paris"),
        ParcelInformation(306, "Delivered", Date(), "Khaled", "San Francisco"),
        ParcelInformation(307, "Delivered", Date(), "Dana", "Miami"),
        ParcelInformation(308, "Delayed due to weather", Date(), "Yousef", "Miami"),
        ParcelInformation(309, "Lost", Date(), "Khaled", "Chicago"),
        ParcelInformation(310, "Awaiting Customs Clearance", Date(), "Omar", "Paris"),
        ParcelInformation(311, "Pending Pickup", Date(), "Zainab", "Dubai")
    )
}