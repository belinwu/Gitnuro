@file:Suppress("unused")

package com.jetpackduba.gitnuro.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.jetpackduba.gitnuro.ui.dropdowns.DropDownOption

private val defaultAppTheme: ColorsScheme = darkBlueTheme
private var appTheme: ColorsScheme = defaultAppTheme

@Composable
fun AppTheme(
    selectedTheme: Theme = Theme.DARK,
    customTheme: ColorsScheme?,
    content: @Composable() () -> Unit
) {
    val theme = when (selectedTheme) {
        Theme.LIGHT -> lightTheme
        Theme.DARK -> darkBlueTheme
        Theme.DARK_GRAY -> darkGrayTheme
        Theme.CUSTOM -> customTheme ?: defaultAppTheme
    }

    appTheme = theme
    val composeColors = theme.toComposeColors()
    MaterialTheme(
        colors = composeColors,
        content = content,
        typography = typography(composeColors),
    )
}

@get:Composable
val Colors.backgroundSelected: Color
    get() = appTheme.backgroundSelected

@get:Composable
val Colors.secondaryTextColor: Color
    get() = appTheme.secondaryText

@get:Composable
val Colors.borderColor: Color
    get() = appTheme.borderColor

@get:Composable
val Colors.headerBackground: Color
    get() = appTheme.headerBackground

@get:Composable
val Colors.addFile: Color
    get() = appTheme.addFile

@get:Composable
val Colors.deleteFile: Color
    get() = appTheme.deletedFile

@get:Composable
val Colors.modifyFile: Color
    get() = appTheme.modifiedFile

@get:Composable
val Colors.conflictFile: Color
    get() = appTheme.conflictingFile

@get:Composable
val Colors.headerText: Color
    get() = appTheme.onHeader

val Colors.abortButton: Color
    get() = appTheme.error

val Colors.scrollbarNormal: Color
    get() = appTheme.normalScrollbar

val Colors.scrollbarHover: Color
    get() = appTheme.hoverScrollbar

val Colors.secondarySurface: Color
    get() = appTheme.secondarySurface

val Colors.dialogOverlay: Color
    get() = appTheme.dialogOverlay

val Colors.diffLineAdded: Color
    get() = appTheme.diffLineAdded

val Colors.diffLineRemoved: Color
    get() = appTheme.diffLineRemoved


enum class Theme(val displayName: String) : DropDownOption {
    LIGHT("Light"),
    DARK("Dark"),
    DARK_GRAY("Dark gray"),
    CUSTOM("Custom");

    override val optionName: String
        get() = displayName
}

val themeLists = listOf(
    Theme.LIGHT,
    Theme.DARK,
    Theme.DARK_GRAY,
    Theme.CUSTOM,
)