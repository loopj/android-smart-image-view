
# Android Smart Image View

## Overview

`SmartImageView` is a drop-in replacement for Android's standard `ImageView` which additionally allows images to be loaded from URLs or the user's contact address book. Images are cached to memory and to disk for super fast loading.

## Features

- Drop-in replacement for `ImageView`
- Load images from a **URL**
- Load images from the phone's **contact address book**
- Asynchronous loading of images, loading happens **outside the UI thread**
- Images are **cached** to memory and to disk for **super fast loading**
- `SmartImage` class is easily **extendable** to load from other sources

## Installation & Basic Usage

Download the latest .jar file from github and place it in your Android app's `libs/` folder.

Add a `SmartImageView` to your activity's xml layout:

```xml
<com.loopj.android.image.SmartImageView android:id="@+id/my_image" />
```

Get a reference to the layout's `SmartImageView`:

```java
SmartImageView myImage = (SmartImageView) this.findViewById(R.id.my_image);
```

Load an image into the view from a URL:

```java
myImage.setImageUrl("http://www.awesomeimages.com/myawesomeimage.jpg");
```

Load an image into the view from the phone's contact address book:

```java
myImage.setImageContact(contactAddressBookId);
```

## Reporting Bugs or Feature Requests

Please report any bugs or feature requests on the github issues page for this project here:

<https://github.com/loopj/android-smart-image-view/issues>

## License

The Android Smart Image View is released under the Android-friendly Apache License, Version 2.0. Read the full license here:

<http://www.apache.org/licenses/LICENSE-2.0>
