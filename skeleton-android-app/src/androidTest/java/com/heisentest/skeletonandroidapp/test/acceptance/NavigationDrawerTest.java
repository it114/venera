package com.heisentest.skeletonandroidapp.test.acceptance;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.test.suitebuilder.annotation.LargeTest;

import android.test.suitebuilder.annotation.Suppress;
import com.heisentest.skeletonandroidapp.MainActivity;
import com.heisentest.skeletonandroidapp.NavigationDrawerFragment;
import com.heisentest.instrumentation.skeletonandroidapp.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.contrib.DrawerActions.closeDrawer;
import static com.google.android.apps.common.testing.ui.espresso.contrib.DrawerActions.openDrawer;
import static com.google.android.apps.common.testing.ui.espresso.contrib.DrawerMatchers.isClosed;
import static com.google.android.apps.common.testing.ui.espresso.contrib.DrawerMatchers.isOpen;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

@LargeTest
public class NavigationDrawerTest extends SkeletonActivityInstrumentationTestCase<MainActivity> {

    public NavigationDrawerTest() {
        super(MainActivity.class);
    }

    @Suppress
    public void testOpenAndCloseDrawer() {
        userHasLearnedAboutNavigationDrawer();

        // The drawer should be closed to start.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        openDrawer(R.id.drawer_layout);

        // The drawer should now be open.
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        closeDrawer(R.id.drawer_layout);

        // Drawer should be closed again.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
    }

    private void userHasLearnedAboutNavigationDrawer() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        sharedPreferences.edit()
                .putBoolean(NavigationDrawerFragment.PREF_USER_LEARNED_DRAWER, true)
                .commit();
    }
}
