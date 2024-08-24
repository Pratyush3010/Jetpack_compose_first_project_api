package com.sb.localassignment.utils


import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sb.localassignment.data.model.*
import java.lang.reflect.Type

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromPrimaryDetails(primaryDetails: PrimaryDetails?): String? {
        return gson.toJson(primaryDetails)
    }

    @TypeConverter
    fun toPrimaryDetails(primaryDetailsJson: String?): PrimaryDetails? {
        return gson.fromJson(primaryDetailsJson, PrimaryDetails::class.java)
    }

    @TypeConverter
    fun fromFeeDetails(feeDetails: FeeDetails?): String? {
        return gson.toJson(feeDetails)
    }

    @TypeConverter
    fun toFeeDetails(feeDetailsJson: String?): FeeDetails? {
        return gson.fromJson(feeDetailsJson, FeeDetails::class.java)
    }

    @TypeConverter
    fun fromJobTags(jobTags: List<JobTag>?): String? {
        return gson.toJson(jobTags)
    }

    @TypeConverter
    fun toJobTags(jobTagsJson: String?): List<JobTag>? {
        val listType: Type = object : TypeToken<List<JobTag>>() {}.type
        return gson.fromJson(jobTagsJson, listType)
    }

    @TypeConverter
    fun fromCreativeList(creatives: List<Creative>?): String? {
        return gson.toJson(creatives)
    }

    @TypeConverter
    fun toCreativeList(creativesJson: String?): List<Creative>? {
        val listType: Type = object : TypeToken<List<Creative>>() {}.type
        return gson.fromJson(creativesJson, listType)
    }

    @TypeConverter
    fun fromLocationList(locations: List<Location>?): String? {
        return gson.toJson(locations)
    }

    @TypeConverter
    fun toLocationList(locationsJson: String?): List<Location>? {
        val listType: Type = object : TypeToken<List<Location>>() {}.type
        return gson.fromJson(locationsJson, listType)
    }

    @TypeConverter
    fun fromStringList(strings: List<String>?): String? {
        return gson.toJson(strings)
    }

    @TypeConverter
    fun toStringList(stringsJson: String?): List<String>? {
        val listType: Type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(stringsJson, listType)
    }

    @TypeConverter
    fun fromContentV3(contentV3: ContentV3?): String? {
        return gson.toJson(contentV3)
    }

    @TypeConverter
    fun toContentV3(contentV3Json: String?): ContentV3? {
        return gson.fromJson(contentV3Json, ContentV3::class.java)
    }

    @TypeConverter
    fun fromContactPreference(contactPreference: ContactPreference?): String? {
        return gson.toJson(contactPreference)
    }

    @TypeConverter
    fun toContactPreference(contactPreferenceJson: String?): ContactPreference? {
        return gson.fromJson(contactPreferenceJson, ContactPreference::class.java)
    }

    @TypeConverter
    fun fromTranslatedContent(translatedContent: Map<String, String>?): String? {
        return gson.toJson(translatedContent)
    }

    @TypeConverter
    fun toTranslatedContent(translatedContentJson: String?): Map<String, String>? {
        val mapType: Type = object : TypeToken<Map<String, String>>() {}.type
        return gson.fromJson(translatedContentJson, mapType)
    }
}
