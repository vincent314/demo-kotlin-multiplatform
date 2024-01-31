package me.vince.fakedataserver

import net.datafaker.providers.base.Commerce

data class Product(
    val name: String,
    val vendor: String,
    val price: Double,
    val brand: String,
){
    companion object {
        fun from(commerce: Commerce):Product = Product(
            name = commerce.productName(),
            vendor = commerce.vendor(),
            price = commerce.price().toDouble(),
            brand = commerce.brand()
        )
    }
}
