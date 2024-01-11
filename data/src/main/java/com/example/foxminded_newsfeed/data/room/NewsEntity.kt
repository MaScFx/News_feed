package com.example.foxminded_newsfeed.data.room

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.foxminded_newsfeed.domain.model.NewsSource
import java.io.ByteArrayOutputStream
import java.time.ZonedDateTime

@Entity
data class LastNewsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val link: String,
    val imgUrl: String,
    val title: String,
    val newsSource: NewsSource,
    val publishedTime: ZonedDateTime,
)
@Entity
data class FavoriteNewsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val link: String,
    var img: Bitmap? = null,
    val imgUrl: String,
    val title: String,
    val newsSource: NewsSource,
    val publishedTime: ZonedDateTime,
)

class ZonedDateTimeConverter(){
    @TypeConverter
    fun zonedDateTimeToString(time: ZonedDateTime):String{
        return time.toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun stringToZonedDateTime(time: String):ZonedDateTime{
        return ZonedDateTime.parse(time)
    }
    @TypeConverter
    fun fromBitmap(bmp: Bitmap): ByteArray{
        val outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }

    @TypeConverter
    fun toBitmap(bytes: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }
}