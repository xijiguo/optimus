package com.optimus.basketbrawl

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class GameModel() : Parcelable {

    var gameName: String = ""
    var startTime: Calendar = Calendar.getInstance()

    constructor(parcel: Parcel) : this() {
        gameName = parcel.readString()
        startTime = Calendar.getInstance()
        startTime.timeInMillis = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gameName)
        parcel.writeLong(startTime.timeInMillis)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GameModel> {
        override fun createFromParcel(parcel: Parcel): GameModel {
            return GameModel(parcel)
        }

        override fun newArray(size: Int): Array<GameModel?> {
            return arrayOfNulls(size)
        }
    }
}