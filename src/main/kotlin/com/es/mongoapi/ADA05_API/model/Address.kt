package com.es.mongoapi.ADA05_API.model


data class Address(
    val country: String,
    val city: String,
    val street: String,
    val door: String,
) {

    override fun toString(): String {
        return "$country, $city, $street"
    }
}
