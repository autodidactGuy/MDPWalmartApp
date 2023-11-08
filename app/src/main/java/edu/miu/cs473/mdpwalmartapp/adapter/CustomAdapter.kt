package edu.miu.cs473.mdpwalmartapp.adapter

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import edu.miu.cs473.mdpwalmartapp.R

class CustomAdapter(context: Context, arrayListImage: ArrayList<Int>, name: Array<String>) : BaseAdapter() {

    //Passing Values to Local Variables

    var context = context
    var arrayListImage = arrayListImage
    var name = name


    //Auto Generated Method
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var myView = convertView
        var holder: ViewHolder

        if (myView == null) {

            val mInflater = (context as Activity).layoutInflater
            myView = mInflater.inflate(R.layout.grid_item, parent, false)
            holder = ViewHolder()

            holder.mImageView = myView!!.findViewById<ImageView>(R.id.imageView) as ImageView
            holder.mTextView = myView!!.findViewById<TextView>(R.id.textView) as TextView
            myView.setTag(holder)
        } else {
            holder = myView.getTag() as ViewHolder

        }

        holder.mImageView!!.setImageResource(arrayListImage.get(position))
        holder.mTextView!!.setText(name.get(position))

        return myView

    }

    override fun getItem(p0: Int): Any {
        return arrayListImage.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return arrayListImage.size
    }
    class ViewHolder {

        var mImageView: ImageView? = null
        var mTextView: TextView? = null

    }

}