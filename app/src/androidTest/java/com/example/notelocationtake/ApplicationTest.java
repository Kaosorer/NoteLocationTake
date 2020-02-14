package com.example.notelocationtake;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void applicationTest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.addNewNoteFAB),
                        childAtPosition(
                                allOf(withId(R.id.relativeLayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextTitle),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Test Title 1"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextContent),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("Test B1"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editTextContent), withText("Test B1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editTextContent), withText("Test B1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.saveFAB),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.addNewNoteFAB),
                        childAtPosition(
                                allOf(withId(R.id.relativeLayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editTextContent),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("Empty Body"), closeSoftKeyboard());

        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.saveFAB),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editTextContent), withText("Empty Body"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editTextTitle),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("Title"), closeSoftKeyboard());

        ViewInteraction floatingActionButton5 = onView(
                allOf(withId(R.id.saveFAB),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton5.perform(click());

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.noteRecyclerView),
                                childAtPosition(
                                        withId(R.id.relativeLayout),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout.perform(click());

        ViewInteraction floatingActionButton6 = onView(
                allOf(withId(R.id.editFAB),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton6.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.editTextTitleEditNote), withText("Title"),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText(""));

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.editTextTitleEditNote),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText9.perform(closeSoftKeyboard());

        ViewInteraction floatingActionButton7 = onView(
                allOf(withId(R.id.updateSaveFAB),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton7.perform(click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.editTextTitleEditNote),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText10.perform(click());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.editTextTitleEditNote),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText11.perform(replaceText("Test Change"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.editTextContentEditNote), withText("Empty Body"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("Empty Body Change"));

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.editTextContentEditNote), withText("Empty Body Change"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText13.perform(closeSoftKeyboard());

        ViewInteraction floatingActionButton8 = onView(
                allOf(withId(R.id.updateSaveFAB),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton8.perform(click());

        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.noteRecyclerView),
                                childAtPosition(
                                        withId(R.id.relativeLayout),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout2.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonNoteDel), withText("Delete"),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction linearLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.noteRecyclerView),
                                childAtPosition(
                                        withId(R.id.relativeLayout),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout3.perform(click());

        ViewInteraction floatingActionButton9 = onView(
                allOf(withId(R.id.editFAB),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton9.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.buttonCancelEditNote), withText("Cancel"),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();

        pressBack();

        ViewInteraction floatingActionButton10 = onView(
                allOf(withId(R.id.addNewNoteFAB),
                        childAtPosition(
                                allOf(withId(R.id.relativeLayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        floatingActionButton10.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.buttonCancel), withText("Cancel"),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction floatingActionButton11 = onView(
                allOf(withId(R.id.addNewNoteFAB),
                        childAtPosition(
                                allOf(withId(R.id.relativeLayout),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        floatingActionButton11.perform(click());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.editTextTitle),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText14.perform(replaceText("Long Body"), closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.editTextContent),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText15.perform(replaceText("TESTTEST testtest FHUAEEKLIIOWOAW "), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText16.perform(click());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText17.perform(click());

        ViewInteraction linearLayout4 = onView(
                allOf(withContentDescription("Select all"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                1),
                        isDisplayed()));
        linearLayout4.perform(click());

        ViewInteraction linearLayout5 = onView(
                allOf(withContentDescription("Copy"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        0),
                                1),
                        isDisplayed()));
        linearLayout5.perform(click());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText18.perform(click());

        ViewInteraction linearLayout6 = onView(
                allOf(withContentDescription("Paste"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                0),
                        isDisplayed()));
        linearLayout6.perform(click());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText19.perform(replaceText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "));

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText20.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText21.perform(click());

        ViewInteraction linearLayout7 = onView(
                allOf(withContentDescription("Select all"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                1),
                        isDisplayed()));
        linearLayout7.perform(click());

        ViewInteraction linearLayout8 = onView(
                allOf(withContentDescription("Copy"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        0),
                                1),
                        isDisplayed()));
        linearLayout8.perform(click());

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText22.perform(click());

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText23.perform(click());

        ViewInteraction linearLayout9 = onView(
                allOf(withContentDescription("Paste"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                0),
                        isDisplayed()));
        linearLayout9.perform(click());

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText24.perform(replaceText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "));

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText25.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText26 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText26.perform(click());

        ViewInteraction appCompatEditText27 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText27.perform(click());

        ViewInteraction linearLayout10 = onView(
                allOf(withContentDescription("Select all"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                1),
                        isDisplayed()));
        linearLayout10.perform(click());

        ViewInteraction linearLayout11 = onView(
                allOf(withContentDescription("Copy"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        0),
                                1),
                        isDisplayed()));
        linearLayout11.perform(click());

        ViewInteraction appCompatEditText28 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText28.perform(click());

        ViewInteraction linearLayout12 = onView(
                allOf(withContentDescription("Paste"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                0),
                        isDisplayed()));
        linearLayout12.perform(click());

        ViewInteraction appCompatEditText29 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText29.perform(replaceText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "));

        ViewInteraction appCompatEditText30 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText30.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText31 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText31.perform(click());

        ViewInteraction appCompatEditText32 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText32.perform(click());

        ViewInteraction linearLayout13 = onView(
                allOf(withContentDescription("Select all"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                1),
                        isDisplayed()));
        linearLayout13.perform(click());

        ViewInteraction linearLayout14 = onView(
                allOf(withContentDescription("Copy"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        0),
                                1),
                        isDisplayed()));
        linearLayout14.perform(click());

        ViewInteraction appCompatEditText33 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText33.perform(click());

        ViewInteraction linearLayout15 = onView(
                allOf(withContentDescription("Paste"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                0),
                        isDisplayed()));
        linearLayout15.perform(click());

        ViewInteraction appCompatEditText34 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText34.perform(replaceText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAWTESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW  "));

        ViewInteraction appCompatEditText35 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAWTESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW  "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText35.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText36 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAWTESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW  "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText36.perform(click());

        ViewInteraction linearLayout16 = onView(
                allOf(withContentDescription("Paste"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                0),
                        isDisplayed()));
        linearLayout16.perform(click());

        ViewInteraction appCompatEditText37 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAWTESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW  "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText37.perform(replaceText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAWTESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW  TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "));

        ViewInteraction appCompatEditText38 = onView(
                allOf(withId(R.id.editTextContent), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAWTESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW  TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText38.perform(closeSoftKeyboard());

        ViewInteraction floatingActionButton12 = onView(
                allOf(withId(R.id.saveFAB),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton12.perform(click());

        ViewInteraction linearLayout17 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.noteRecyclerView),
                                childAtPosition(
                                        withId(R.id.relativeLayout),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayout17.perform(click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.textViewContentActEdit), withText("TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAWTESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW  TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW TESTTEST testtest FHUAEEKLIIOWOAW "),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.buttonNoteDel), withText("Delete"),
                        childAtPosition(
                                allOf(withId(R.id.topRowContainer),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton4.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
