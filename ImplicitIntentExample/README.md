# ImplicitIntentExample
This repo shows how start Activities via implicit Intents and how to
receive implicit intents in an app with intent filters.

### Things to Note (click to jump to code):
- [Declaring intent-filters for 3 Activites in our app: FirstActivity, SecondActivity, and ThirdActivity]()
- [intentWithTwoMatchingFilters fires an implicit Intent which matches both
FirstActivity and SecondActivity. The user will be prompted with the app
chooser to pick which app they want to fulfill the Intent. In this case,
since both Activities are in the IntentExample app, the chooser will list
"IntentExample" twice. In a real scenario, if an implicit Intent matches
more than one intent-filter, these Activities will be in different apps,
and the app chooser will show different apps]()
- [intentWithOneMatchingFilter fires an implicit Intent which only matches
ThirdActivity, since ThirdActivity's intent-filter is the only one matching
the action "com.example.IntentExample.CUSTOM_ACTION_OTHER". The user will
not be prompted with the app chooser dialog in this case, since the OS
knows there's only 1 matching Activity]()
- [explicitIntent starts ThirdActivity explicitly since it provides the
component name directly (FirstActivity.class). This will go directly
to ThirdActivity and does not go through any intent-filters since it
is an explicit Intent. This is only in this app to demonstrate how implict
and explict intents can co-exist]()