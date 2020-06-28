package oi.github.messiaslima

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        onView(withId(R.id.mainBinaryNumberEditText)).perform(clearText())
    }

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

    @Test
    fun editTextCannotReceiveOtherThanBinaries() {
        onView(withId(R.id.mainBinaryNumberEditText)).perform(typeText("a"))
        onView(withId(R.id.mainBinaryNumberEditText)).check(matches(withText("")))
        onView(withId(R.id.mainBinaryNumberEditText)).perform(typeText("3"))
        onView(withId(R.id.mainBinaryNumberEditText)).check(matches(withText("")))
        onView(withId(R.id.mainBinaryNumberEditText)).perform(typeText("01"))
        onView(withId(R.id.mainBinaryNumberEditText)).check(matches(withText("01")))
    }

    @Test
    fun theRightValueMustBeShown() {
        onView(withId(R.id.mainBinaryNumberEditText)).perform(typeText("01"))
        onView(withId(R.id.mainDecimalNumberTextView)).check(matches(withText("1")))

        onView(withId(R.id.mainBinaryNumberEditText)).perform(clearText())

        onView(withId(R.id.mainBinaryNumberEditText)).perform(typeText("111"))
        onView(withId(R.id.mainDecimalNumberTextView)).check(matches(withText("7")))

        onView(withId(R.id.mainBinaryNumberEditText)).perform(clearText())

        onView(withId(R.id.mainBinaryNumberEditText)).perform(typeText("1101"))
        onView(withId(R.id.mainDecimalNumberTextView)).check(matches(withText("13")))
    }
}