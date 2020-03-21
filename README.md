[![](https://jitpack.io/v/nightcrawler-/android-model-to-view.svg)](https://jitpack.io/#nightcrawler-/android-model-to-view)

# android-model-to-view

This library includes a custom widget that makes it simpler to present models with a large number of fields with minimum effort. It uses the names and values of each field in your model to build a presentation layout with just a few lines of code.


### Installation

On your project level build.gradle:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

Then on your module level gradle file:

```
dependencies {
	        implementation 'com.github.nightcrawler-:android-model-to-view:<version>'
	}

```

### Usage

Initialize the `ModelToView` object by passing a `RecyclerView` to the constructor. This `RecyclerView` will host the name-value pairs extracted from your model.

Call `modelToView.setModel(<your model>)` to extract and display contents.

* You can pass a custom adapter and layout manager for a more fine grained presentaton.
* The library has a number of annotations for your fields to control the extraction of the name-value pairs.

### Available annotations

```
@Capitalize - Return the titles/field names in all uppercase
@IgnoreExtraction - Skip the field
@Extracted name - Use a different name for the extracted title (different from the field name)
@MeasurementUnit - Append a measurement unit at the end of the extracted value

```

