package com.tanriverdi.androidonboardingscreen.onboarding

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OnboardingGraphUI (onboardingModel: OnboardingModel){


    Column(modifier = Modifier.fillMaxWidth()) {


        Spacer(
            modifier =  Modifier
                .size(60.dp)
        )

        Image(
            painter = painterResource(id = onboardingModel.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp,0.dp),
            alignment = Alignment.Center
        )

        Spacer(
            modifier = Modifier
                .size(60.dp)
                .fillMaxWidth()
        )

        Text(
            text = onboardingModel.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp,0.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )


        Spacer(
            modifier = Modifier
                .size(10.dp)
                .fillMaxWidth()
        )

        Text(
            text = onboardingModel.description, // Açıklama metni onboardingModel'den alınır
            modifier = Modifier
                .fillMaxWidth() // Metin tam genişlikte yer kaplar
                .padding(15.dp,0.dp),// Açıklama metnine yatay dolgu ekleniyor
            fontSize = 16.sp,// Açıklama metninin font boyutu
            textAlign = TextAlign.Center,// Açıklama metnini ortalar
            style = MaterialTheme.typography.bodySmall,// Temadan tipografi stili uygulanır
            color= MaterialTheme.colorScheme.onSurface, // Temanın yüzey rengi seçilir
        )

        Spacer(
            modifier = Modifier
                .size(10.dp)
                .fillMaxWidth()
        )

    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphPreview1(){
    OnboardingGraphUI(OnboardingModel.FirstPage)
}
@Preview(showBackground = true)
@Composable
fun OnboardingGraphPreview2(){
    OnboardingGraphUI(OnboardingModel.SecondPage)
}
@Preview(showBackground = true)
@Composable
fun OnboardingGraphPreview3(){
    OnboardingGraphUI(OnboardingModel.ThirdPage)
}