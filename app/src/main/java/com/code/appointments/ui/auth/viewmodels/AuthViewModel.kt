package com.code.appointments.ui.auth.viewmodels

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.code.appointments.ui.auth.data.AppUser
import com.code.appointments.ui.auth.data.Result
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val fbAuth = FirebaseAuth.getInstance()
    private val dbRef = FirebaseDatabase.getInstance()
    private val storageRef = FirebaseStorage.getInstance()
    private var authStatusSuccess = false
    fun register(user: AppUser, password: String) {
        fbAuth.createUserWithEmailAndPassword(user.email, password)
            .addOnSuccessListener {
                if (it.user != null) {
                    val userRef = dbRef.getReference("/user/${it.user!!.uid}")
                    userRef.setValue(user)
                        .addOnSuccessListener {
                            authStatusSuccess = true
                        }.addOnFailureListener {
                            authStatusSuccess = false
                        }
                }
            }
            .addOnFailureListener {
                authStatusSuccess = false
            }
    }

    fun saveImage(imageUri: Uri) {
        storageRef.getReference("user").putFile(imageUri)
            .addOnSuccessListener {
                Log.i("AuthViewModel", "saveImage(Success) <--")
                it.storage.downloadUrl
                    .addOnSuccessListener {
                        it.toString()
                    }.addOnFailureListener {

                    }
            }.addOnFailureListener {
                Log.e("saveImage(${it.message}) <--", it.cause.toString())
            }
    }
}