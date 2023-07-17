package com.code.appointments.ui.auth.data

import androidx.fragment.app.Fragment
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Locale

data class AppUser(
    val id: String,
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val imageUrl: String?,
    val role: Role,
    val dateCreated: String = SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss'Z'",
        Locale.getDefault()
    ).format(System.currentTimeMillis()),
    private val dateUpdated: String = SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss'Z'",
        Locale.getDefault()
    ).format(System.currentTimeMillis())
)

data class Role(
    val isDoctor: Boolean = false,
    val isPatient: Boolean = false,
    val roleDescription: String?
)

data class PagerItem(val fragment: Fragment, val title: String)

sealed class Result {
    sealed class Success(data: Any) : Result()
    sealed class Error(message: Any) : Result()
}