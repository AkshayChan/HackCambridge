package com.javasampleapproach.kotlin.csv
 
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList
 
private val RECIPE_TITLE_IDX = 0
private val RECIPE_DIRECTIONS_IDX = 1
private val RECIPE_INGREDIENTS_IDX = 2
private val RECIPE_CALORIES = 3
 
fun main(args: Array<String>?) {
	var fileReader: BufferedReader? = null
 
	try {
		val customers = ArrayList<Recipe>()
		var line: String?
 
		fileReader = BufferedReader(FileReader("finito.csv"))
 
		// Read CSV header
		fileReader.readLine()
 
		// Read the file line by line starting from the second line
		line = fileReader.readLine()
		while (line != null) {
			val tokens = line.split(",")
			if (tokens.size > 0) {
				val recipe = Recipe(
						tokens[RECIPE_TITLE_IDX],
						tokens[RECIPE_DIRECTIONS_IDX],
						tokens[RECIPE_INGREDIENTS_IDX],
						Double.parseDouble(tokens[RECIPE_CALORIES]))
				recipes.add(recipe)
			}
			
			line = fileReader.readLine()
		}
		
		// Print the new customer list
		for (recipe in recipes) {
			println(recipe)
		}
	} catch (e: Exception) {
		println("Reading CSV Error!")
		e.printStackTrace()
	} finally {
		try {
			fileReader!!.close()
		} catch (e: IOException) {
			println("Closing fileReader Error!")
			e.printStackTrace()
		}
	}
}