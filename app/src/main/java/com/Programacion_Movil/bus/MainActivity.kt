package com.Programacion_Movil.bus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapaBuses()
        }
    }
}

@Composable
fun MapaBuses() {
    val context = LocalContext.current

    AndroidView(
        factory = { ctx ->
            MapView(ctx).apply {
                onCreate(null)
                getMapAsync { googleMap ->
                    val parada1 = LatLng(-16.5, -68.1)
                    googleMap.addMarker(
                        MarkerOptions().position(parada1).title("Parada 1")
                    )
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(parada1, 12f))
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}