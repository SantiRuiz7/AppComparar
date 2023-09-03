package com.example.primerapp.view

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.primerapp.R
import org.junit.Rule
import org.junit.Test

import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }


    @Test
    fun testCompareButton() {
        // Ingreso texto 1
        onView(withId(R.id.inputText1)).perform(typeText("Hello"))

        // Ingreso texto 2
        onView(withId(R.id.inputText2)).perform(typeText("World"))

        onView(isRoot()).perform(closeSoftKeyboard())

        onView(withId(R.id.btn_compare)).perform(click())

        // El resultado es "Son iguales"?
        onView(withId(R.id.show_result)).check(matches(withText("Son iguales")))
    }

}