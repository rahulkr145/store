package com.rahul.store.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Store {

    @Id
    var id: Int = 1

    var code: String = ""
    var description: String = ""
    var name: String = ""
    var openingDate: LocalDate = LocalDate.now()
    var storeType: String = ""
}
