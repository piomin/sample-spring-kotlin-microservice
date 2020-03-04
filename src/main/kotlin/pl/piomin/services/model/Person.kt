package pl.piomin.services.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Person(@Id var id: Int?, var name: String, var age: Int, var gender: Gender)