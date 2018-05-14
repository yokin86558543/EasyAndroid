package com.haoge.usefulcodes

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ListActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import com.haoge.usefulcodes.activities.DimenConverterActivity
import com.haoge.usefulcodes.activities.EasyFormaterActivity
import com.haoge.usefulcodes.activities.EasyLogActivity
import com.haoge.usefulcodes.activities.EasyToastActivity
import com.haoge.usefulcodes.utils.easy.EasyLog

/**
 * @author haoge on 2018/5/9
 */
class DemosActivity:ListActivity() {

    private val mContainer = arrayListOf<Item<*>>(
            Item("测试EasyToast", EasyToastActivity::class.java),
            Item("测试EasyFormater", EasyFormaterActivity::class.java),
            Item("测试EasyLog", EasyLogActivity::class.java),
            Item("测试DimenConverter", DimenConverterActivity::class.java)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = DemosAdapter(this, mContainer)
        Log.e("DemosActivity", "onCreate: (DemosActivity.kt:31)")

    }
}

data class Item<T:Activity>(val text:String, val clazz:Class<T>)

class DemosAdapter(var context:Context, var mContainer: ArrayList<Item<*>>) : BaseAdapter() {

    val mInflater = LayoutInflater.from(context)

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val button:Button = mInflater.inflate(R.layout.item_demo_list, parent, false) as Button
        button.text = getItem(position).text
        button.setOnClickListener { context.startActivity(Intent(context, getItem(position).clazz) ) }
        return button
    }

    override fun getItem(position: Int): Item<*> = mContainer.get(position)

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = mContainer.size

}