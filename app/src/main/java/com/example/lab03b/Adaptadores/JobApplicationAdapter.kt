package com.example.lab03b.Adaptadores

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab03b.LogicaNegocio.JobApplication
import com.example.lab03b.R
import kotlinx.android.synthetic.main.item_job_application.view.*

open class JobApplicationAdapter(
    private val context: Context,
    private var list:ArrayList<JobApplication>
) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_job_application,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]
        if(holder is MyViewHolder){
            holder.itemView.tvFullName.text = "${model.firstName} ${model.lastName}"
            holder.itemView.tvEmail.text = model.email
            holder.itemView.tvPhoneNumber.text = model.phoneNumber.toString()
            holder.itemView.setOnClickListener {
                if (onClickListener != null)
                    onClickListener!!.onClick(position, model)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun notifyEditItem(activity: Activity, position: Int, requestCode: Int) {
        /*val intent = Intent(context, AddJobApplicationActivity::class.java)
        intent.putExtra(ListActivity.EXTRA_PLACE_DETAILS, list[position])
        activity.startActivityForResult(
            intent,
            requestCode
        )

        notifyItemChanged(position) */
    }

    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: JobApplication)
    }

    private class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}