# AncestralNavigationExample
Examples of [ancestral navigation](https://developer.android.com/training/implementing-navigation/ancestral)
(a.k.a "Up navigation")

### Things to Note (click to jump to code):
- When you hit the 'Up' button in SubChildActivity, you will go
back to MainActivity, NOT back to the activity that started it
 (ChildActivity)
- [This](https://github.com/joegalley/AndroidExamples/blob/master/AncestralNavigationExample/app/src/main/AndroidManifest.xml#L29)
 is where the ancestral navigation is set up