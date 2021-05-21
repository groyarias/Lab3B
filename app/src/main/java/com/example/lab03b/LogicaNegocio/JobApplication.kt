package com.example.lab03b.LogicaNegocio

import java.io.Serializable
import java.util.*

class JobApplication(
    firstName:String,
    lastName:String,
    mainStreetAddress:String,
    lineStreetAddress:String,
    city:String,
    state:String,
    postal:Int,
    country:String,
    email:String,
    areaCode:String,
    phoneNumber:Int,
    applyingPosition:String,
    startDate:Date
):Serializable {
     var firstName:String = ""
     var lastName:String = ""
     var mainStreetAddress:String = ""
     var lineStreetAddress:String = ""
     var city:String = ""
     var state:String = ""
     var postal:Int = 0
     var country:String = ""
     var email:String = ""
     var areaCode:String = ""
     var phoneNumber:Int = 0
     var applyingPosition:String = ""
     var startDate:Date = Date()

    init {
        this.firstName = firstName
        this.lastName = lastName
        this.mainStreetAddress = mainStreetAddress
        this.lineStreetAddress = lineStreetAddress
        this.city = city
        this.state = state
        this.postal = postal
        this.country = country
        this.email = email
        this.areaCode = areaCode
        this.phoneNumber = phoneNumber
        this.applyingPosition = applyingPosition
        this.startDate = startDate
    }
}