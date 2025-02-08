package com.vovka.cameratemplate

import android.Manifest


object Constants {
    const val TAG = "CameraX"
    const val FILE_NAME_FORMAT = "yy-MM-dd-HH-mm-ss-SSS"
    const val REQUEST_CODE_PERMISSIONS_CAMERA = 123
    val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
}