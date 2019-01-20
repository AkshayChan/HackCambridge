package com.example.akshayc.studenteats

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner


class PreferencesActivity : AppCompatActivity() {

    var activitySpinner: Spinner? = null
    var genderSpinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)


        //Declaring the spinner here - connecting it to the object
        activitySpinner = findViewById(R.id.spinner1)

        //Adding the list to the adapter
        var splist: ArrayList<String> = arrayListOf("Sedentary", "Low Activity", "Active", "Very Active")

        var activityAdapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, splist)

        //Assigning the adapter to the spinners adapter
        activitySpinner?.adapter = activityAdapter


        //Declaring the spinner here - connecting it to the object
        genderSpinner = findViewById(R.id.spinner2)

        //Adding the list to the adapter
        var splist2: ArrayList<String> = arrayListOf("Male", "Female")

        var genderAdapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, splist2)

        //Assigning the adapter to the spinners adapter
        genderSpinner?.adapter = genderAdapter

    }

    fun recipeActivity(view: View): Unit {
        val intent = Intent(this, RecipeActivity::class.java)
        val message1 = activitySpinner?.selectedItem.toString().trim()
        val message2 = genderSpinner?.selectedItem.toString().trim()

        val edittext1 = findViewById<EditText>(R.id.editText1) as EditText
        val edittext2 = findViewById<EditText>(R.id.editText2) as EditText
        val edittext3 = findViewById<EditText>(R.id.editText3) as EditText

        val message3 = edittext1.text.toString()
        val message4 = edittext2.text.toString()
        val message5 = edittext3.text.toString()

        val activity = message1
        val gender = message2
        //System.out.println(gender);
        val height = message3.toInt()
        val weight = message4.toInt()
        val age = message5.toInt()

        var act = 0.0
        var EER = 0.0
        var BMI = 0.0

        if (gender.toUpperCase() === "MALE") {
            if (activity.toUpperCase() == "SEDENTARY"){
                act = 1.0
            }
            else if (activity.toUpperCase() == "LOW ACTIVITY"){
                act = 1.11
            }
            else if (activity.toUpperCase() == "ACTIVITY"){
                act = 1.26
            }
            else {
                act = 1.48
            }
            EER = 662 - 9.53 * age + act * 15.91 * weight.toDouble() + 5.396 * height
            BMI = weight/(height.toDouble() * height.toDouble() * 0.0001)
        } else {
            if (activity.toUpperCase() == "SEDENTARY"){
                act = 1.0
            }
            else if (activity.toUpperCase() == "LOW ACTIVITY"){
                act = 1.12
            }
            else if (activity.toUpperCase() == "ACTIVITY"){
                act = 1.27
            }
            else {
                act = 1.45
            }
            EER = 354 - 6.91 * age + act * 9.36 * weight.toDouble() + 7.26 * height
            BMI = weight/(height.toDouble() * height.toDouble() * 0.0001)
        }

        intent.putExtra("calorie", EER.toString())
        intent.putExtra("BMI", BMI.toString())


        Log.d("Output", message1 + "  " + message2 + "  " + message3 + "  " + message4 + "  " + message5 + "  " +EER + "  " + BMI)

        startActivity(intent)

    }
}
