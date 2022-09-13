package com.rich.viewmodeltask.model

import java.io.Serializable

data class News(val date:String, val title:String, val image:Int, val jurnalis:String, val description:String) : Serializable