# Button
Examples of a Button view back by a state list drawable

### Things to Note (click to jump to code):
- [Defining the Button backed by a Drawable resoure](https://github.com/joegalley/AndroidExamples/blob/master/ButtonExample/app/src/main/res/layout/activity_main.xml#L13-L23)
- [The state list Drawable. Notice the state for "state_pressed" and
"state_selected". The last state is defined at the bottom and doesn't
have a defined state. This is the default "catch-all" state. So if the
button is not in state_pressed or state_selected, this drawable will be
applied](https://github.com/joegalley/AndroidExamples/blob/master/ButtonExample/app/src/main/res/drawable/button_states.xml)
- [To toggle state_selected, we must do this in Java code](https://github.com/joegalley/AndroidExamples/blob/master/ButtonExample/app/src/main/java/com/example/buttonexample/MainActivity.java#L22-L31)
