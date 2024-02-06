package com.s.myapplication

import android.annotation.SuppressLint

 data class Orders(var productId: String,var productNames: List<String>,var Quantity: Map<String, Int>) {

}