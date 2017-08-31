package ca.bell.test.app;

/**
 * Created by VG00328850 on 8/31/2017.
 */
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    private static final String ADD_RESULT = "98";
    private static final String ADD_value1 = "90";
    private static final String Add_value2 = "8";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.value1))
                .perform(typeText(ADD_value1), closeSoftKeyboard());

        onView(withId(R.id.value2))
                .perform(typeText(Add_value2), closeSoftKeyboard());

        onView(withId(R.id.addValues)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.result)).check(matches(withText(ADD_RESULT)));
    }
}
