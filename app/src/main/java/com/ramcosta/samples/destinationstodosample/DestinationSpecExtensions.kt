package com.ramcosta.samples.destinationstodosample

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.*

@Composable
fun Destination.DrawerContent(
    isSelected: Boolean,
    onDestinationClick: (Destination) -> Unit
) {
    when (this) {
        FeedDestination,
        GreetingDestination,
        SettingsDestination -> {
            Text(
                text = stringResource(id = title),
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        onDestinationClick(this)
                    },
                fontWeight = if (isSelected) FontWeight.Bold else null
            )
        }
        ProfileDestination,
        ThemeSettingsDestination -> { }
    }
}

fun Destination.destinationPadding(parentPadding: PaddingValues): Modifier {
    return when (this) {
        ThemeSettingsDestination,
        GreetingDestination,
        FeedDestination,
        ProfileDestination -> Modifier.padding(parentPadding)

        SettingsDestination -> Modifier.padding(
            start = 0.dp,
            end = 0.dp,
            top = parentPadding.calculateTopPadding() + 10.dp,
            bottom = parentPadding.calculateBottomPadding() + 10.dp
        )
    }
}

@get:StringRes
val Destination.title get(): Int {
    return when (this) {
        GreetingDestination -> R.string.greeting_screen
        ProfileDestination -> R.string.profile_screen
        SettingsDestination -> R.string.settings_screen
        FeedDestination -> R.string.feed_screen
        ThemeSettingsDestination -> R.string.theme_settings_screen
    }
}