package com.rahul.store.controller

import com.rahul.store.service.StoreService
import com.rahul.store.entity.Store
import com.rahul.store.dto.StoreDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody

@RestController
@CrossOrigin
class StoreController(private val storeService: StoreService) {

    @GetMapping("/store")
    fun getStore(): ResponseEntity<List<Store>> {
        return ResponseEntity.ok(storeService.getStore())
    }

    @GetMapping("/store/{page}")
    fun saveAllStore(@PathVariable("page") page: Int): ResponseEntity<List<StoreDTO>> {
        return ResponseEntity.ok(storeService.saveStores(page))
    }

    @PostMapping("/store")
    fun saveStore(@RequestBody store: Store): ResponseEntity<Store> {
        return ResponseEntity.ok(storeService.saveStore(store))
    }
}
