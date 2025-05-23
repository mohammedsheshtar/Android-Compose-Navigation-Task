package com.muhammed.android_compose_navigation_task

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.muhammed.android_compose_navigation_task.composables.DetailsScreen
import com.muhammed.android_compose_navigation_task.composables.ParcelScreen
import com.muhammed.android_compose_navigation_task.composables.WelcomeScreen
import com.muhammed.android_compose_navigation_task.data.ParcelInformation
import com.muhammed.android_compose_navigation_task.repositories.ParcelsRepository

enum class NavRoutesEnum(val value: String) {
    NAV_ROUTE_DETAILS_SCREEN("detailsScreen"),
    NAV_ROUTE_HOME_SCREEN("homeScreen"),
    NAV_ROUTE_PARCEL_SCREEN("parcelScreen")
}

@Composable
fun ParcelNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavRoutesEnum.NAV_ROUTE_HOME_SCREEN.value
) {
    var parcelsState by remember { mutableStateOf(ParcelsRepository.parcels)}
    var selectedParcel by remember { mutableStateOf<ParcelInformation?>(null) }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavRoutesEnum.NAV_ROUTE_HOME_SCREEN.value) {
            WelcomeScreen(modifier) { parcelId ->
                navController.navigate("${NavRoutesEnum.NAV_ROUTE_DETAILS_SCREEN.value}/$parcelId")
            }
        }

        composable("${NavRoutesEnum.NAV_ROUTE_DETAILS_SCREEN.value}/{parcelId}") {backStackEntry ->
            val parcelId = backStackEntry.arguments?.getString("parcelId")?.toIntOrNull()
            val parcel = parcelsState.find { it.parcelId == parcelId }

            DetailsScreen(
                parcel = parcel,
                onViewParcelInfo = {
                    selectedParcel = it
                    navController.navigate(NavRoutesEnum.NAV_ROUTE_PARCEL_SCREEN.value)
                },
                onBackHome = {
                    navController.popBackStack(NavRoutesEnum.NAV_ROUTE_HOME_SCREEN.value, inclusive = false)
                }
            )
        }

        composable(NavRoutesEnum.NAV_ROUTE_PARCEL_SCREEN.value) {
            ParcelScreen(
                parcel = selectedParcel,
                onGoBack = { navController.popBackStack() }
            )
        }
    }
}