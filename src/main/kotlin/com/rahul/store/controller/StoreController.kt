package com.rahul.store.controller

import com.rahul.store.service.StoreService
import com.rahul.store.entity.Store
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity

@RestController
class StoreController(private val storeService: StoreService) {

    @GetMapping("/store")
    fun getStore(): ResponseEntity<List<Store>> {
        return ResponseEntity.ok(storeService.getStore())
    }
}
