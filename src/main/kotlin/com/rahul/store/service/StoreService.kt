package com.rahul.store.service

import com.rahul.store.entity.Store
import com.rahul.store.repository.StoreRepository
import org.springframework.stereotype.Service

@Service
class StoreService(private val storeRepository: StoreRepository) {
    fun getStore(): List<Store> {
        return storeRepository.findAll()
    }
}
