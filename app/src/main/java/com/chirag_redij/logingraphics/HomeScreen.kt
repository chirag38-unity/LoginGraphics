package com.chirag_redij.logingraphics

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.chirag_redij.logingraphics.destinations.LoginScreenDestination
import com.chirag_redij.logingraphics.destinations.RegisterScreenDestination
import com.chirag_redij.logingraphics.ui.theme.zeyadaFontFamily
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(
    start = true,
    style = SlideTransition::class
)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {

    val lottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.peoples_transform)
    )
    val progress by animateLottieCompositionAsState(
        composition = lottieComposition,
        iterations = LottieConstants.IterateForever
    )
    Scaffold(

    ) { scaffoldPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding)
        ) {

            Text(
                text = "For Anyone & Everyone",
                fontFamily = zeyadaFontFamily,
                fontSize = 70.sp,
                textAlign = TextAlign.Start,
                lineHeight = 50.sp,
                overflow = TextOverflow.Visible,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(y = 24.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            LottieAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                composition = lottieComposition,
                progress = { progress }
            )

            Column(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {

                FilledButton(
                    title = "Login",
                ) { navigator.navigate(LoginScreenDestination) }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(title = "Register") {
                    navigator.navigate(RegisterScreenDestination)
                }

                Spacer(modifier = Modifier.height(100.dp))

            }

            Text(
                text = "Continue as Guest",
                color = Color.Cyan,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
            )

        }
    }
}

@Composable
fun FilledButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
                .padding(8.dp),
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
    }
}

@Composable
fun OutlinedButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        border = BorderStroke(2.dp, Color.Black),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
                .padding(8.dp),
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
    }
}

object SlideTransition : DestinationStyle.Animated {
    override fun AnimatedContentTransitionScope<NavBackStackEntry>.enterTransition(): EnterTransition? {

        return slideInHorizontally(
            initialOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(700)
        )

    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.exitTransition(): ExitTransition? {

        return slideOutHorizontally(
            targetOffsetX = { fullWidth -> -fullWidth },
            animationSpec = tween(700)
        )
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.popEnterTransition(): EnterTransition? {

        return slideInHorizontally(
            initialOffsetX = { fullWidth -> -fullWidth },
            animationSpec = tween(700)
        )
    }

    override fun AnimatedContentTransitionScope<NavBackStackEntry>.popExitTransition(): ExitTransition? {
        return slideOutHorizontally(
            targetOffsetX = { fullWidth -> fullWidth },
            animationSpec = tween(700)
        )
    }
}