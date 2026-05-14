package com.rajat.ShopTrack

import android.app.Application
import com.rajat.myshopcart.data.Graph

class MyShopCartApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}