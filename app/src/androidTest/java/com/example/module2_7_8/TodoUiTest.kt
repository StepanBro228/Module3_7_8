package com.example.module2_7_8

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TodoUiTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun allThreeTodosAreDisplayed() {
        composeTestRule.onNodeWithText("Купить молоко").assertIsDisplayed()
        composeTestRule.onNodeWithText("Позвонить маме").assertIsDisplayed()
        composeTestRule.onNodeWithText("Сделать ДЗ по Android").assertIsDisplayed()
    }

    @Test
    fun checkboxTogglesStatus() {
        composeTestRule.onNodeWithTag("checkbox_1").assertIsOff()
        composeTestRule.onNodeWithTag("checkbox_1").performClick()
        composeTestRule.onNodeWithTag("checkbox_1").assertIsOn()
    }

    @Test
    fun navigationListToDetailToList() {
        composeTestRule.onNodeWithText("Купить молоко").performClick()
        composeTestRule.onNodeWithText("Не выполнено").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Назад").performClick()
        composeTestRule.onNodeWithText("Позвонить маме").assertIsDisplayed()
    }
}
