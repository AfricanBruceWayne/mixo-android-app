package com.mixo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Comment(val uid: String, val author: String, val text: String): Parcelable {
    constructor() : this("", "", "")
}