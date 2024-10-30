# Onboarding Screen

This project includes an onboarding screen that users see upon their first entry into the application.
When the user completes the onboarding process, their status is saved, and the application no longer redirects them to the onboarding screen.

### Features

- **Multiple Onboarding Pages**: Consists of three pages that inform the user.
- **Indicators**: Includes page indicators to show the user which page they are currently on.
- **Status Saving**: Saves the status once the onboarding process is completed and redirects the user to the main screen.
- **Jetpack Compose Usage**: All UI components are written using Jetpack Compose.

### Project Structure

- **OnboardingModel.kt**: A data class containing an image, title, and description for each onboarding page.
- **OnboardingGraphUI.kt**: A component that displays the images and text of the onboarding pages.
- **IndicatorUI.kt**: A component that indicates which page the user is currently on.
- **OnboardingScreen.kt**: Facilitates the user's completion of onboarding steps, including next and back buttons.
- **OnboardingUtils.kt**: Saves the onboarding status using SharedPreferences.
- **MainActivity.kt**: Redirects the user to the main screen if they have completed the onboarding process.

### Installation Steps

1. **Define the data for each onboarding screen using `OnboardingModel.kt`:**

    ```kotlin
    sealed class OnboardingModel(
        @DrawableRes val image: Int,
        val title: String,
        val description: String,
    ) {
        data object FirstPage : OnboardingModel(R.drawable.image1, "Title 1", "Description 1")
        data object SecondPage : OnboardingModel(R.drawable.image2, "Title 2", "Description 2")
        data object ThirdPage : OnboardingModel(R.drawable.image3, "Title 3", "Description 3")
    }
    ```

2. **Create the page layout with `OnboardingGraphUI.kt`:**

    - Populate the content of each page by filling in the Image, Title, and Description fields.

3. **Add page indicators using `IndicatorUI.kt`:**

    - Utilize the IndicatorUI component to indicate which page the user is currently on.

4. **Start the onboarding process with `OnboardingScreen.kt`:**

    - Implement horizontal swiping between pages using `HorizontalPager`.
    - Use the `Scaffold` component to structure the next/back buttons and indicators.

5. **Manage state with `OnboardingUtils.kt`:**

    - Save the onboarding status using the `setOnboardingCompleted` function when the user completes the onboarding process.

6. **Set up `MainActivity.kt`:**

    - Check the onboarding status using `onboardingUtils`.
    - Call `ShowHomeScreen` if the user has completed onboarding; otherwise, call `ShowOnboardingScreen`.
  

### Usage

- Each time the application is opened, `MainActivity` checks the onboarding status.
- If the user has completed the onboarding process, they are redirected to the main screen; if not, they will see the onboarding screen.




