# Button
Examples of a Button view back by a state list drawable

### Things to Note (click to jump to code):
- [Defining the Button backed by a Drawable resoure]()
- [The state list Drawable. Notice the state for "state_pressed" and
"state_selected". The last state is defined at the bottom and doesn't
have a defined state. This is the default "catch-all" state. So if the
button is not in state_pressed or state_selected, this drawable will be
applied]()
- [To toggle state_selected, we must do this in Java code]()