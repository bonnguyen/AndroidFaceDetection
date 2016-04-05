# AndroidFaceDetection
This is Android lib to help all projects can easy integrate Camera with face detection feature.
<table>
  <tr>
    <td width="480"><img src="http://i.imgur.com/lDA3f2c.png"/></td>
    <td width="480"><img src="http://i.imgur.com/EVPCdKd.jpg"/></td>
  </tr>
</table>

Status
======

- Current stable version: [ ![Download](https://api.bintray.com/packages/bonnguyen/maven/camerafacedetection/images/download.svg) ](https://bintray.com/bonnguyen/maven/camerafacedetection/_latestVersion)
- Current development version: n/a

Get It
===

- Maven repository: jCenter
- Group: com.github.bonnguyen
- Artifact ID: camerafacedetection

What's new (1.0.0)
==========
- Only supported take one picture for one time
- Display the result on screen
 
Installation
============

Release versions are available from jCenter repository, so just add the "compile..." statement to your project. For snapshots, please
add our bintray snapshots repository url first: https://dl.bintray.com/bonnguyen/maven

```groovy
repositories{
    maven {
        url 'https://dl.bintray.com/bonnguyen/maven'
    }
}
```
And put it in App dependencies:

```groovy
dependencies {
    ...
    compile 'com.github.bonnguyen:camerafacedetection:1.0.0'
    ...
}
```

Quick Usage
===========
Easy to integrate with your project. In your XML layout, you can put the FaceDetectionView

```groovy
<com.bonnguyen.camerafacedetection.FaceDetectionView
    android:id="@+id/ivPhoto"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:src="@drawable/ic_no_photo" />
```

Configuration and Start
=============


In <b>Java</b> code

```groovy
ivPhoto = (FaceDetectionView) findViewById(R.id.ivPhoto);
ivPhoto.setOnClickListener(this);
....

@Override
public void onClick(View view) {
    if (view == ivPhoto) {
        Intent intent = new Intent(this, AndroidCameraActivity.class);
        startActivityForResult(intent, REQUEST_CAMERA);
    }
}
```

And get the result after take:
```groovy
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK) {
        if (requestCode == REQUEST_CAMERA && data.hasExtra("url")) {
            String photoPath = data.getStringExtra("url");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeFile(photoPath, options);
            ivPhoto.setImageBitmap(bitmap);
        }
    }
}
```

Bugs, Suggestions, Ideas
========================
Any ideas/bugs/etc, as well as pull requests, are welcome in the [issues section](https://github.com/bonnguyen/AndroidFaceDetection/issues).

DEVELOP BY
===================================
[Bon Nguyen](https://github.com/bonnguyen) - nguyennhatbon07t1@gmail.com

LICENSE
===================================
<br/>
The MIT License (MIT)

Copyright (c) 2016 Bon Nguyen.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
<br/>       
