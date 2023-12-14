package com.chirag_redij.logingraphics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chirag_redij.logingraphics.ui.theme.arvoFontFamily
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Destination(
    style = SlideTransition::class
)
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
) {

    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val (a, b, c) = FocusRequester.createRefs()

    Scaffold { scaffoldPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding)
        ) {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Spacer(modifier = Modifier.height(108.dp))
                BoldHeader(heading = "Welcome back! Glad to see you, Again!")
                Spacer(modifier = Modifier.height(70.dp))
                OutlinedInput(placeHolder = "Enter your email!", a, b, focusManager)
                Spacer(modifier = Modifier.height(20.dp))
                OutLinedPasswordField(placeHolder = "Enter your Password", b, focusManager)
                Spacer(modifier = Modifier.height(40.dp))
                FilledButton(title = "Login") {

                }
                Spacer(modifier = Modifier.height(30.dp))
                ButtonDivider(title = "Or Login With")
                Spacer(modifier = Modifier.height(30.dp))
                ContentProviderRow()
                Spacer(modifier = Modifier.height(80.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black
                            )
                        ) {
                            append("Dont have an account? ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Cyan
                            )
                        ) {
                            append("Register Now!")
                        }
                    },
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            BackButton(
                navigator = navigator,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 24.dp, y = 24.dp)
            )


        }
    }
}

@Composable
fun ContentProviderRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedIconButton(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook Login",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedIconButton(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            onClick = { /*TODO*/ },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Login",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedIconButton(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            onClick = { /*TODO*/ },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "Apple Login",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun ButtonDivider(
    title: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Divider(modifier = Modifier.weight(1f))
        Text(
            text = title, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp),
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.outline,
            textAlign = TextAlign.Center
        )
        Divider(modifier = Modifier.weight(1f))
    }
}

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator
) {
    OutlinedIconButton(
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outline),
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        onClick = { navigator.popBackStack() }
    ) {
        Icon(
            tint = MaterialTheme.colorScheme.outline,
            imageVector = Icons.Default.ArrowBackIos,
            contentDescription = "Back to Main Screen",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedInput(
    placeHolder: String,
    self: FocusRequester,
    next: FocusRequester,
    focusManager: FocusManager,
    modifier: Modifier = Modifier
) {
    var email by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .focusRequester(self)
            .focusProperties {
                this.next = next
            },
        value = email, onValueChange = { email = it },
        placeholder = {
            Text(text = placeHolder)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.surface,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedBorderColor = Color.Black,
            unfocusedTextColor = MaterialTheme.colorScheme.outline,
            focusedTextColor = Color.Black
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Next)
            }
        )
    )
}

@Composable
fun BoldHeader(heading: String) {
    Text(
        text = heading,
        fontFamily = arvoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        textAlign = TextAlign.Start,
        lineHeight = 30.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLinedPasswordField(
    placeHolder: String,
    self: FocusRequester,
    focusManager: FocusManager,
    modifier: Modifier = Modifier
) {
    var password by remember {
        mutableStateOf("")
    }
    var isVisible by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .focusRequester(self),
        value = password, onValueChange = { password = it },
        placeholder = {
            Text(text = placeHolder)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.surface,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedBorderColor = Color.Black,
            unfocusedTextColor = MaterialTheme.colorScheme.outline,
            focusedTextColor = Color.Black
        ),
        trailingIcon = {
            IconButton(onClick = { isVisible = !isVisible }) {
                if (isVisible) {
                    Icon(
                        imageVector = Icons.Default.VisibilityOff,
                        contentDescription = "Hide password"
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Visibility,
                        contentDescription = "Show password"
                    )
                }
            }
        },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        supportingText = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Forgot Password?",
                textAlign = TextAlign.End,
                color = MaterialTheme.colorScheme.outline
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        )
    )
}