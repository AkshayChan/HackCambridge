package com.example.akshayc.studenteats

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.AdapterView



class ShopListActivity : AppCompatActivity() {

    var lis = ""
    var listv: ListView? = null
    var items: ArrayList<String>? = null
    var itemsAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_list)

        val inten = intent

        //Get the string which has ingredients split by newline
        lis = inten.getStringExtra("ingredient")

        //Get the list view object
        listv = findViewById(R.id.listv)

        //Split the string on newline
        items = ArrayList(lis.split("\n"))

        //Create the adapter with the list of items and set its value
        itemsAdapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, items)
        listv?.setAdapter(itemsAdapter)

        setupListViewListener()
    }

    private fun setupListViewListener() {
        listv?.setOnItemLongClickListener(
                object : AdapterView.OnItemLongClickListener {
                  override fun onItemLongClick(adapter: AdapterView<*>,
                                        item: View, pos: Int, id: Long): Boolean {
                        // Remove the item within array at position
                        items?.removeAt(pos)
                        // Refresh the adapter
                        itemsAdapter?.notifyDataSetChanged()
                        // Return true consumes the long click event (marks it handled)
                        return true
                    }

                })
    }
}
