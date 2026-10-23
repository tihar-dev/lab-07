package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//verify you can go from homescreen to driversscreen
//verify that you can add atleast one driver and the driver is displayed
// verify that clear the drivers from the list
// verify that the back button takes you back to the homescreen

@RunWith(AndroidJUnit4::class)
 class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }



@Test
fun navigate_to_drivers_add_and_clear_drivers_and_return_home() {
    // navigate to race screen
    composeTestRule
        .onNodeWithTag("driversButton")
        .performClick()

    // verify race screen
    composeTestRule
        .onNodeWithText("FormulaZero Drivers")
        .assertExists()

    // enter race location
    composeTestRule
        .onNodeWithTag("driverInput")
        .performTextInput("Sam")

    // add race location
    composeTestRule
        .onNodeWithTag("addDriverButton")
        .performClick()

    // verify race appears
    composeTestRule
        .onNodeWithText("Sam")
        .assertExists()

    // clear all drivers
    composeTestRule
        .onNodeWithTag("clearDriversButton")
        .performClick()

    // verify drivers were removed
    composeTestRule
        .onNodeWithText("Sam")
        .assertDoesNotExist()

    // return to home screen
    composeTestRule
        .onNodeWithTag("driversBackButton")
        .performClick()

    // verify return to home screen
    composeTestRule
        .onNodeWithText("FormulaZero Home")
        .assertExists()
}
}

