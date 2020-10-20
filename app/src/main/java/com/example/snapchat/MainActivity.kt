package com.example.snapchat

import android.R.attr.password
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    var emailEdt: EditText?=null
    var passwdEdt: EditText?=null
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEdt=findViewById(R.id.emailEdt)
        passwdEdt=findViewById(R.id.passwdEdt)

        if(mAuth.currentUser!= null){

        }
    }

    fun goClicked(view: View){
        //check if can login the user
        mAuth.signInWithEmailAndPassword(emailEdt?.text.toString(), passwdEdt?.text.toString())
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    logIn()
                } else {
                    //sigup user
                    mAuth.createUserWithEmailAndPassword(emailEdt?.text.toString(), passwdEdt?.text.toString()).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            //add to data
                            logIn()
                        } else {
                            Toast.makeText(this, "Login Failed.Try Again", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }  // ...
    }
    fun logIn(){
        //move to next activity
        val intent = Intent(this,SnapActivity::class.java)
        startActivity(intent)
    }
}