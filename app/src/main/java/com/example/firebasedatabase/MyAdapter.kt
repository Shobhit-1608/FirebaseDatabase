package com.example.firebasedatabase

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val userList : ArrayList<User>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        val user: User =  userList[position]
        holder.firstName.text = user.firstName
        holder.lastName.text = user.lastName
    }

    override fun getItemCount(): Int {

        return userList.size
    }

    public class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val firstName: TextView = itemView.findViewById<TextView>(R.id.tvFirstName)
        val lastName: TextView = itemView.findViewById<TextView>(R.id.tvLastName)


    }
}