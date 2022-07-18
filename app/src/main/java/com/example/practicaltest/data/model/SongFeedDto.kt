package com.example.practicaltest.data.model

import com.google.gson.annotations.SerializedName

data class SongFeedDto(
    @SerializedName("entry")
    val songs: List<SongDataDto>
)

data class SongDataDto(
    @SerializedName("id")
    val songIdDto: SongIdDto,
    @SerializedName("im:image")
    val images: List<ImageDto>,
    @SerializedName("title")
    val title: TitleDto,
    @SerializedName("link")
    val links: List<LinkDTO>
) {
    data class SongIdDto(
        @SerializedName("label")
        val label : String,
        @SerializedName("attributes")
        val attributes: AttributeDto,
    ) {
        data class AttributeDto(
            @SerializedName("im:id")
            val id: String,
        )
    }

    data class ImageDto(
        @SerializedName("label")
        val imageUrl: String,
    )

    data class TitleDto(
        @SerializedName("label")
        val name: String,
    )

    data class LinkDTO (
        @SerializedName("attributes")
        val attributes: AttributeDto,
            ){
        data class AttributeDto(
            @SerializedName("title")
            val title: String,
            @SerializedName("rel")
            val rel: String,
            @SerializedName("type")
            val type: String,
            @SerializedName("href")
            val href: String,
            @SerializedName("im:assetType")
            val assetType: String
        )
    }


}

