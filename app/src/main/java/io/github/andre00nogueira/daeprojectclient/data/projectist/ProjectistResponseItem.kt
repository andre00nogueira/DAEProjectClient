package io.github.andre00nogueira.daeprojectclient.data.projectist


import com.google.gson.annotations.SerializedName

data class ProjectistResponseItem(
    val address: String,
    val email: String,
    val id: Int,
    val name: String,
    //val projectDTOs: List<Any>
)