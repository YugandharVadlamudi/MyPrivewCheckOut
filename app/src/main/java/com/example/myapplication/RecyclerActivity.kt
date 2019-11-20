package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_main.adapter = MultiItem(this)
    }


    class MultiItem(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view: View?
            if (viewType == 0) {
                view = LayoutInflater.from(context).inflate(R.layout.inflate_restaurent_item, parent, false)
                return RestaurentViewHolder(view)
            } else {
                view = LayoutInflater.from(context).inflate(R.layout.inflate_rowitem_add, parent, false)
                return AddViewHolder(context,view)
            }

        }


        override fun getItemCount(): Int {
            return 11
        }


        override fun getItemViewType(position: Int): Int {
            if (position >= 10) {
                return 1
            } else {
                return 0
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if (holder is RestaurentViewHolder) {
            } else if (holder is AddViewHolder) {
                val a = holder as AddViewHolder
                a.button.text = "hello${position}"
                a.button.setOnClickListener(object: View.OnClickListener {
                    override fun onClick(p0: View?) {
                        Toast.makeText(context, "Hello4", Toast.LENGTH_SHORT).show();
                    }
                })
            }
        }

        open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        }

        class RestaurentViewHolder(itemView: View) : BaseViewHolder(itemView) {

        }

        class AddViewHolder(val context:Context, itemView: View) : BaseViewHolder(itemView),OnButtonClick {
            override fun onButtonClick() {
                Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
            }

           val button :Button = itemView.findViewById<Button>(R.id.button)
        }
        interface OnButtonClick{
            fun onButtonClick()
        }
    }

}
