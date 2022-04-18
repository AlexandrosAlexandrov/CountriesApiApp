package com.example.uniapi

data class CountryUnisItem(
    val country: String,
    val domains: List<String>,
    val name: String,
    val web_pages: List<String>
)