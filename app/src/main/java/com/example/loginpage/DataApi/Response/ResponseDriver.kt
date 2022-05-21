package com.example.loginpage.DataApi.Response

data class ResponseDriver(val success: Boolean,
                          val message: String,
                          val data: DriverData,
                          val token: String

                          )
