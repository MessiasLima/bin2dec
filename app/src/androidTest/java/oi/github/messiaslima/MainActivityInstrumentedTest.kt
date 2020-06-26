package oi.github.messiaslima

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("oi.github.messiaslima", appContext.packageName)
    }

    @Test
    fun assertWidgetsVisibility() {
        onView(withId(R.id.mainBinaryNumberEditText)).check(matches(isDisplayed()))
        onView(withId(R.id.mainDecimalNumberTextView)).check(matches(isDisplayed()))
        onView(withId(R.id.mainDecimalNumberTextView)).check(matches(withText("0")))
    }
}