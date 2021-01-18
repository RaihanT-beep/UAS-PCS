package com.example.test_uas.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val Login:String = "",
    val avatarUrl:String = "",
    val htmlUrl:String = "",
    val followers:String = "",
    val following:String = ""
) : Parcelable