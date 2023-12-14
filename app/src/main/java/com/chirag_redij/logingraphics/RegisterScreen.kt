package com.chirag_redij.logingraphics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Destination(
    style = SlideTransition::class
)
@Composable
fun RegisterScreen(
    navigator: DestinationsNavigator
) {

    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val (a, b, c, d, e) = FocusRequester.createRefs()
    val bringIntoViewRequester = BringIntoViewRequester()

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
                BoldHeader(heading = "Towards New Experiences & Memories")
                Spacer(modifier = Modifier.height(50.dp))
                OutlinedInput(
                    placeHolder = "Username",
                    self = a,
                    next = b,
                    focusManager = focusManager,
                    modifier = Modifier.onFocusEvent {
                        if (it.isFocused) {
                            coroutineScope.launch {
                                bringIntoViewRequester.bringIntoView()
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedInput(
                    placeHolder = "Email",
                    self = b,
                    next = c,
                    focusManager = focusManager,
                    modifier = Modifier.onFocusEvent {
                        if (it.isFocused) {
                            coroutineScope.launch {
                                bringIntoViewRequester.bringIntoView()
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                RegisterScreenPasswordField(
                    placeHolder = "Password",
                    self = c,
                    next = d,
                    focusManager = focusManager,
                    modifier = Modifier.onFocusEvent {
                        if (it.isFocused) {
                            coroutineScope.launch {
                                bringIntoViewRequester.bringIntoView()
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                RegisterScreenPasswordField(
                    placeHolder = "Confirm Password",
                    self = d,
                    next = d,
                    focusManager = focusManager,
                    isLast = true,
                    modifier = Modifier.onFocusEvent {
                        if (it.isFocused) {
                            coroutineScope.launch {
                                bringIntoViewRequester.bringIntoView()
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.height(40.dp))
                FilledButton(
                    modifier = Modifier.bringIntoViewRequester(bringIntoViewRequester),
                    title = "Agree and Register"
                ) {

                }
                Spacer(modifier = Modifier.height(30.dp))
                ButtonDivider(title = "Or Login With")
                Spacer(modifier = Modifier.height(30.dp))
                ContentProviderRow()

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreenPasswordField(
    placeHolder: String,
    self: FocusRequester,
    next: FocusRequester,
    focusManager: FocusManager,
    isLast: Boolean = false,
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
            .focusRequester(self)
            .focusProperties {
                this.next = next
            },
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
        singleLine = true,
        keyboardOptions = if (isLast) KeyboardOptions(imeAction = ImeAction.Done) else KeyboardOptions(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Next)
            },
            onDone = {
                focusManager.clearFocus()
            }
        )
    )
}