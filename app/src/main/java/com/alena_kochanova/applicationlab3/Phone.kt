package com.alena_kochanova.applicationlab3

class Phone internal constructor(var name: String, var price: Int) {

    override fun toString(): String {
        return "$name $price"
    }

}