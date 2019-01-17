package pl.piomin.services.model

data class Person(var id: Int?) {
    var name: String? = null
    var age: Int? = null
    var gender: Gender? = null

    constructor(id: Int?, name: String?, age: Int?, gender: Gender?) : this(id) {
        this.name = name
        this.age = age
        this.gender = gender
    }
}