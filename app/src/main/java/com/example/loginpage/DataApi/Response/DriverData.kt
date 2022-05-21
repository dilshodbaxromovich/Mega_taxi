package com.example.loginpage.DataApi.Response

data class DriverData(val user_id: Int,
                      val branch_id: Int,
                      val user_full_name: String,
                      val user_phone: String,
                      val user_type: String,
                      val user_status: String,
                      val driver_balance: DriverBalance
)
