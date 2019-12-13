package com.mixo.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Cocktail(val uid: String, val name: String, val recipe: String, val description: String): Parcelable {
    constructor() : this("", "", "", "")
}