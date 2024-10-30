package com.tanriverdi.androidonboardingscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.tanriverdi.androidonboardingscreen.onboarding.OnboardingScreen
import com.tanriverdi.androidonboardingscreen.onboarding.OnboardingUtils
import com.tanriverdi.androidonboardingscreen.ui.theme.AndroidOnboardingScreenTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    // OnboardingUtils örneğini lazy yükleme ile başlat
    private val onboardingUtils by lazy { OnboardingUtils(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Kenarlardan kenara görüntüleme modunu etkinleştir

        setContent {
            AndroidOnboardingScreenTheme  {  // Temayı ayarlayın
                Surface (color = MaterialTheme.colorScheme.background){
                    // Onboarding dreamland ana ekranı göster, aksi takdirde onboarding ekranını göster
                    if (onboardingUtils.isOnboardingCompleted()) {
                        ShowHomeScreen()
                    } else {
                        ShowOnboardingScreen()

                    }
                }
            }

        }
    }



    @Composable
    private fun ShowHomeScreen() {

        Column {
            Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
        }


    }
    // Onboarding ekranını gösteren bileşen
    @Composable
    private fun ShowOnboardingScreen() {
        val scope = rememberCoroutineScope() // Coroutine kapsamını hatırla
        OnboardingScreen {
            onboardingUtils.setOnboardingCompleted() // Onboarding tamamlandığında durumu güncelle
            scope.launch {
                setContent {
                    ShowHomeScreen() // Onboarding tamamlandığında ana ekranı göster
                }
            }
        }


    }
}




