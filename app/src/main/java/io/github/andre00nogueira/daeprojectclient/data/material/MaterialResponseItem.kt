package io.github.andre00nogueira.daeprojectclient.data.material


import com.google.gson.annotations.SerializedName

data class MaterialResponseItem(
    val id: Int,
    val materialTypeId: Int,
    val name: String,
   // val structureDTOList: List<Any>
)