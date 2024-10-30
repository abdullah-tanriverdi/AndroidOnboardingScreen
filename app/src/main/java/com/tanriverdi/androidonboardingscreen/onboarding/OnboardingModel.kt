package com.tanriverdi.androidonboardingscreen.onboarding

import androidx.annotation.DrawableRes
import com.tanriverdi.androidonboardingscreen.R


//Farklı onboarding ekranlarını temsil eden sealed class
sealed class OnboardingModel (
     @DrawableRes val  image: Int,
    val title: String,
    val description: String,
 ) {

    //Belirli bir resim, başlık ve açıklama ile onboarding sayfaları
    data object FirstPage : OnboardingModel(
        image = R.drawable.ogo,
        title = "First Title",
        description = "First Description"
    )

    data object SecondPage : OnboardingModel(
        image = R.drawable.ogo,
        title = "Second Title",
        description = "Second Description"
    )

    data object ThirdPage : OnboardingModel(
        image = R.drawable.ogo,
        title = "Third Title",
        description = "Third Description"
    )

}