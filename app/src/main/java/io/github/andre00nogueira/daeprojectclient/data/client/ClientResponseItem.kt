package io.github.andre00nogueira.daeprojectclient.data.client


import com.google.gson.annotations.SerializedName

data class ClientResponseItem(
    val address: String,
    val email: String,
    val id: Int,
    val name: String,
    //val projectDTOs: List<Any>
)