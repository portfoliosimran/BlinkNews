package com.sandhu.blinknews.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.sandhu.blinknews.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConvertor {

    @TypeConverter
    fun fromSource(source: Source): String {
        return "${source.name},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String): Source {
        return source.split(",").let {
            sourceArray -> Source(sourceArray[0],sourceArray[1])
        }
    }
}