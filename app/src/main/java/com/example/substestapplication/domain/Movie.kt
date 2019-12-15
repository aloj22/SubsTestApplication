package com.example.substestapplication.domain

import android.os.Parcel
import android.os.Parcelable
import java.util.*


data class Movie(
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean, val posterPath: String,
    val id: Long,
    val adult: Boolean, val backdropPath: String,
    val originalLanguage: String?,
    val originalTitle: String?,
    val title: String, val voteAverage: Double,
    val overview: String,
    val releaseDate: Date
) : Parcelable {

    constructor(source: Parcel) : this(
        source.readDouble(),
        source.readInt(),
        1 == source.readInt(),
        source.readString(),
        source.readLong(),
        1 == source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readDouble(),
        source.readString(),
        source.readSerializable() as Date
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeDouble(popularity)
        writeInt(voteCount)
        writeInt((if (video) 1 else 0))
        writeString(posterPath)
        writeLong(id)
        writeInt((if (adult) 1 else 0))
        writeString(backdropPath)
        writeString(originalLanguage)
        writeString(originalTitle)
        writeString(title)
        writeDouble(voteAverage)
        writeString(overview)
        writeSerializable(releaseDate)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie = Movie(source)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }
}