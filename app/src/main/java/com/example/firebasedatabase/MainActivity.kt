package com.example.firebasedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        saveBtn.setOnClickListener(){
            val firstName = inputFirstName.text.toString()
            val lastName = inputLastName.text.toString()
            saveFirestore(firstName, lastName)
        }
        readFirestore()
    }

    private fun saveFirestore(firstName: String, lastName: String) {
        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["firstName"] = firstName
        user["lastName"] = lastName

        db.collection("users")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this@MainActivity, "record added successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{
                Toast.makeText(this@MainActivity, "record adding failed", Toast.LENGTH_SHORT).show()

            }


        readFirestore()
    }

    fun readFirestore(){
        val db = FirebaseFirestore.getInstance()
        db.collection("users")
            .get()
            .addOnCompleteListener(){

                val result: StringBuffer = StringBuffer()
                if(it.isSuccessful){
                    for(document in it.result !!){
                        result.append(document.data.getValue("firstName")).append(" ")
                            .append(document.data.getValue("lastName")).append("\n\n ")

                    }
                    updates.setText(result)
                }
            }
    }
}