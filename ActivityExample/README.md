# ActivityExample
This repo shows how to create a basic activity for your app

### Things to Note:
- We create a MainActivity class in Java
- Create an XML layout for the MainActivity called "activity_main.xml"
- Connect activity_main.xml with MainActivity
- Declare MainActivity in the Manifest file. This must be done so you app knows about the activity
- Create an Intent Filter for MainActivity with category "LAUNCHER", so that it's the launcher activity for our app. A "launcher" activity is the first Activity shown by default when the user presses the app icon from the home screen.