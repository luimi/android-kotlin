package models

import android.content.Intent

class Module (val title: String,val intent: Intent){
    override fun toString(): String {
        return this.title
    }
}

