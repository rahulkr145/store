package com.rahul.store.service

import com.rahul.store.dto.StoreDTO
import com.rahul.store.entity.Store
import com.rahul.store.repository.StoreRepository
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StoreService(private val storeRepository: StoreRepository) {
    fun getStore(): List<Store> {
        return storeRepository.findAll()
    }

    @Transactional
    fun saveStores(page: Int): List<StoreDTO> {
        val restTemplate = RestTemplateBuilder().build()
        val headers = HttpHeaders()
        //We can use encryption or vault for apiKey
        headers.set("apiKey", "nxzAAC1EQAAU7AGY8gUQnev_99A")
        val entity = HttpEntity<String>(headers)
        val stores = restTemplate.exchange(
            "http://134.209.29.209/v1/stores/?page=$page", HttpMethod.GET,
            entity, typeReference<List<StoreDTO>>()
        ).body!!
        for (store in stores) {
            storeRepository.save(store.toStore())
        }
        return stores
    }

    fun saveStore(store: Store): Store {
        return storeRepository.save(store)
    }
    private inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}
}
