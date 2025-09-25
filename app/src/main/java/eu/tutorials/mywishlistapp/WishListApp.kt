package eu.tutorials.mywishlistapp

import android.app.Application
import eu.tutorials.mywishlistapp.data.Graph

class WishListApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}