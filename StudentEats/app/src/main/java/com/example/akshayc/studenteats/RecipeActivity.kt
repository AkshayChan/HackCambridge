package com.example.akshayc.studenteats


import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import org.json.JSONArray
import org.json.JSONObject
import java.io.FileReader
import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import java.util.Random


class RecipeActivity : AppCompatActivity() {

    var textv: TextView? = null
    var textv2: TextView? = null
    var textv3: TextView? = null
    var textv4: TextView? = null
    //var BMI = ""
    var EER: String? = null
    var splitext = ""
    var ingredients : List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val intent = intent

        //BMI = intent.getStringExtra("BMI")
        EER = intent.getStringExtra("calorie")

        var maxcal = EER!!.toDouble()
        maxcal = maxcal/6.0

        Log.d("calorie", maxcal.toString())

        textv = findViewById(R.id.textView10)
        textv2 = findViewById(R.id.textView11)
        textv3 = findViewById(R.id.textView12)
        textv4 = findViewById(R.id.textView13)


        /*
        val sb = StringBuilder()

        try {
            val inputStream: InputStream = assets.open("sample.json")
            val inputStreamReader = InputStreamReader(inputStream)
            var line: String?
            val br = BufferedReader(inputStreamReader)
            while (br.readLine() != null) {
                line = br.readLine()
                sb.append(line)
            }
            line = br.readLine()
            sb.append(line)
            br.close()
            Log.d("Data", sb.toString())
        } catch (e: Exception) {
            //Log.d("Data", e.toString())
        }*/

        //val jr = JSONArray(sb.toString())
        //val js = jr.getJSONObject(0).get("directions")
        //Log.d("lalal", js.toString())


        //Read CSV file

        var fileReader: BufferedReader? = null
        var csvReader: CSVReader? = null

        try
        {
            val inputStream = assets.open("final.csv")
            val inputStreamReader = InputStreamReader(inputStream)
            fileReader = BufferedReader(inputStreamReader)
            csvReader = CSVReaderBuilder(fileReader).withSkipLines(1).build()

            val records = csvReader.readAll()
            for (i in records.indices) {
                Log.d("index", i.toString())
                if (records[i][3].toInt() > maxcal) {

                    val rand = i - 2

                    textv?.text = records[rand][0]
                    textv2?.text = records[rand][1]


                    ingredients = records[rand][2].split('.')

                    for (rec in ingredients.orEmpty()) {
                        splitext = splitext + rec + "\n"
                    }

                    textv3?.text = splitext
                    textv4?.text = "Total Meal Calories: " +  records[rand][3]
                    //Log.d("Hello", _record[0] + " | " + _record[1][1] + " | " + _record[2][1] + " | " + _record[3])
                    break
                }
            }
        } catch (e: Exception) {
            println("Reading CSV Error!")
            e.printStackTrace()
        }
    }

    fun sendShopList(view: View): Unit {
        val inte = Intent(this, ShopListActivity::class.java)
        inte.putExtra("ingredient", splitext)
        startActivity(inte)
    }
}

