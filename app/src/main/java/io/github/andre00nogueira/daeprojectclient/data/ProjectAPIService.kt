package io.github.andre00nogueira.daeprojectclient.data

import io.github.andre00nogueira.daeprojectclient.data.client.ClientResponse
import io.github.andre00nogueira.daeprojectclient.data.client.ClientResponseItem
import io.github.andre00nogueira.daeprojectclient.data.material.MaterialResponse
import io.github.andre00nogueira.daeprojectclient.data.material.MaterialResponseItem
import io.github.andre00nogueira.daeprojectclient.data.material_type.MaterialTypeResponse
import io.github.andre00nogueira.daeprojectclient.data.material_type.MaterialTypeResponseItem
import io.github.andre00nogueira.daeprojectclient.data.projectist.ProjectistResponse
import io.github.andre00nogueira.daeprojectclient.data.projectist.ProjectistResponseItem
import io.github.andre00nogueira.daeprojectclient.data.project.ProjectResponse
import io.github.andre00nogueira.daeprojectclient.data.project.ProjectResponseItem
import io.github.andre00nogueira.daeprojectclient.data.structure.StructureResponse
import io.github.andre00nogueira.daeprojectclient.data.structure.StructureResponseItem
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

//localhost:8080/projectbackend/api/projectists

interface ProjectAPIService {
    @GET("projectists")
    suspend fun getAllProjectists() : ProjectistResponse

    @GET("projectists/{id}")
    suspend fun getProjectistDetails(@Path(value = "id", encoded = true) projectistId : Int) : ProjectistResponseItem

    @GET("projectists/{id}/projects")
    suspend fun getProjectistProjects(@Path(value = "id", encoded = true) projectistId : Int) : ProjectResponse

    @POST("projectists")
    suspend fun createNewProjectist(@Body projectistResponseItem: ProjectistResponseItem)

    @GET("projects")
    suspend fun getAllProjects() : ProjectResponse

    @GET("projects/{id}")
    suspend fun getProjectDetails(@Path(value = "id", encoded = true) projectId : Int) : ProjectResponseItem

    @GET("projects/{id}/projectists")
    suspend fun getProjectProjectists(@Path(value = "id", encoded = true) projectId : Int) : ProjectistResponse

    @GET("projects/{id}/structures")
    suspend fun getProjectStructures(@Path(value = "id", encoded = true) projectId : Int) : StructureResponse

    @POST("projects")
    suspend fun createNewProject(@Body projectResponseItem: ProjectResponseItem)

    @GET("clients")
    suspend fun getAllClients() : ClientResponse

    @GET("clients/{id}")
    suspend fun getClientDetails(@Path(value = "id", encoded = true) clientId : Int) : ClientResponseItem

    @GET("clients/{id}/projects")
    suspend fun getClientProjects(@Path(value = "id", encoded = true) clientId : Int) : ProjectResponse

    @POST("clients")
    suspend fun createNewClient(@Body clientResponseItem: ClientResponseItem)

    @GET("structures")
    suspend fun getAllStructures() : StructureResponse

    @GET("structures/{id}")
    suspend fun getStructureDetails(@Path(value = "id", encoded = true) structureId : Int) : StructureResponseItem

    @GET("structures/{id}/materials")
    suspend fun getStructureMaterials(@Path(value = "id", encoded = true) structureId : Int) : MaterialResponse

    @POST("structures")
    suspend fun createNewStructure(@Body structureResponseItem: StructureResponseItem)

    @GET("materialTypes")
    suspend fun getAllMaterialTypes() : MaterialTypeResponse

    @GET("materialTypes/{id}")
    suspend fun getMaterialTypeDetails(@Path(value = "id", encoded = true) materialTypeId : Int) :  MaterialTypeResponseItem

    @GET("materialTypes/{id}/materials")
    suspend fun getMaterialTypeMaterials(@Path(value = "id", encoded = true) materialTypeId : Int) : MaterialResponse

    @GET("materialTypes/{id}/structures")
    suspend fun getMaterialTypeStructures(@Path(value = "id", encoded = true) materialTypeId : Int) : StructureResponse

    @POST("materialTypes")
    suspend fun createNewMaterialType(@Body materialTypeResponseItem: MaterialTypeResponseItem)

    @GET("materials")
    suspend fun getAllMaterials() : MaterialResponse

    @GET("materials/{id}")
    suspend fun getMaterialDetails(@Path(value = "id", encoded = true) materialId : Int) : MaterialResponseItem

    @GET("materials/{id}/structures")
    suspend fun getMaterialStructures(@Path(value = "id", encoded = true) materialTypeId : Int) : StructureResponse

    @POST("materials")
    suspend fun createNewMaterial(@Body materialResponseItem: MaterialResponseItem)



    companion object {
        operator fun invoke(): ProjectAPIService {
            val okHttpClient = OkHttpClient.Builder()
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://10.0.2.2:8080/projectbackend/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProjectAPIService::class.java)
        }
    }
}