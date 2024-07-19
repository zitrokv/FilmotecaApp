package com.example.filmotecaapp.data

import com.google.gson.annotations.SerializedName

/*
data class PeliculasListResponse(
    @SerializedName("Response") val response:String,
    @SerializedName("totalResults") val resultsFor: Int,
    @SerializedName("Search") val results: List<PeliculasResponse> = emptyList()
){

}
data class PeliculasResponse(
    @SerializedName("Title") val titulo: String,
    @SerializedName("Year") val anyo: String,
    @SerializedName("imdbID") val id: String,
    @SerializedName("Type") val tipo: String,
    @SerializedName("Poster") val poster: String,

    @SerializedName("Plot") val sinopsis: String?,
    @SerializedName("Runtime") val duracion: String?,
    @SerializedName("Director") val director: String?,
    @SerializedName("Genre") val genero: String?,
    @SerializedName("Country") val pais: String?
)
*/

data class PeliculasListResponseT(
    @SerializedName("Response") val response:String,
    @SerializedName("totalResults") val resultsFor: Int,
    @SerializedName("Search") val results: List<PeliculasResponseT> //= emptyList()
)

data class PeliculasResponseS(
    @SerializedName("Title") val titulo: String,
    @SerializedName("Year") val anyo: String,
    @SerializedName("imdbID") val id: String,
    @SerializedName("Type") val tipo: String,
    @SerializedName("Poster") val poster: String,
    @SerializedName("Response") val responseS: String

)

data class PeliculasResponseT(
    val Info : PeliculasResponseS,

    @SerializedName("Plot") val sinopsis: String?,
    @SerializedName("Runtime") val duracion: String?,
    @SerializedName("Director") val director: String?,
    @SerializedName("Genre") val genero: String?,
    @SerializedName("Country") val pais: String?,
    @SerializedName("Response") val responseT: String
)
