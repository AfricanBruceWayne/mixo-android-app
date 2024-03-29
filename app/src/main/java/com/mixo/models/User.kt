package com.mixo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(val uid: String, val username: String, val email: String): Parcelable {
    constructor() : this("", "", "")
}