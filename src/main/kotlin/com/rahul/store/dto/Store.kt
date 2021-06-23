package com.rahul.store.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.rahul.store.entity.Store
import java.time.LocalDate

val mapper: ObjectMapper = ObjectMapper()
    .registerModule(KotlinModule())

@JsonIgnoreProperties(ignoreUnknown = true)
data class StoreDTO(
    var id: Int = -1,
    var code: String? = "",
    var description: String? = "",
    var name: String? = "",
    var openingDate: LocalDate? = LocalDate.now(),
    var storeType: String? = ""
) {
    fun toStore(): Store = Store(
        id = this.id,
        code = this.code,
        description = this.description,
        name = this.name,
        openingDate = this.openingDate,
        storeType = this.storeType
    )
}
