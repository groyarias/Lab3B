package com.example.lab03b

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab03b.AccesoDatos.ModelData
import com.example.lab03b.Adaptadores.JobApplicationAdapter
import com.example.lab03b.LogicaNegocio.JobApplication
import com.example.swiperecyclerview.utils.SwipeToDeleteCallback
import com.example.swiperecyclerview.utils.SwipeToEditCallback
import java.util.ArrayList


class FragmentList : Fragment() {
    private var model: ModelData? = null
    private var jobApplicationsList: ArrayList<JobApplication>? = null
    private var rv_job_application_list:RecyclerView? = null
    private var tv_no_records_available: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        model = ModelData

        jobApplicationsList = model!!.obtenerJobApplications()


        var view: View? = null
        view = inflater.inflate(R.layout.fragment_list, container, false)
        rv_job_application_list = view.findViewById(R.id.rv_job_application_list)
        tv_no_records_available = view.findViewById(R.id.tv_no_records_available)


        if (jobApplicationsList!!.size > 0) {

            rv_job_application_list?.visibility = View.VISIBLE
            tv_no_records_available?.visibility = View.GONE
            setupListApplicationRecyclerView(jobApplicationsList!!)

        } else {
            rv_job_application_list?.visibility = View.GONE
            tv_no_records_available?.visibility = View.VISIBLE
        }

        return view
    }

    private fun setupListApplicationRecyclerView(jobApplicationsList: ArrayList<JobApplication>) {

        rv_job_application_list?.layoutManager = LinearLayoutManager(requireContext())
        rv_job_application_list?.setHasFixedSize(true)

        val jobAppAdapter: JobApplicationAdapter = JobApplicationAdapter(requireContext(), jobApplicationsList)
        rv_job_application_list?.adapter = jobAppAdapter

        jobAppAdapter.setOnClickListener(object : JobApplicationAdapter.OnClickListener{
            override fun onClick(position: Int, model: JobApplication) {

                Toast.makeText(requireContext(), "${model.firstName}", Toast.LENGTH_SHORT)
                /*
                val intent = Intent(this@MainActivity, HappyPlaceDetailActivity::class.java)
                intent.putExtra(EXTRA_PLACE_DETAILS, model) // Passing the complete serializable data class to the detail activity using intent.
                startActivity(intent)
                * */

            }
        })


        val editSwipeHandler = object : SwipeToEditCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = rv_job_application_list?.adapter as JobApplicationAdapter
                adapter.notifyEditItem(
                    requireActivity(),
                    viewHolder.adapterPosition,
                    ADD_PLACE_ACTIVITY_REQUEST_CODE
                )
            }
        }
        val editItemTouchHelper = ItemTouchHelper(editSwipeHandler)
        editItemTouchHelper.attachToRecyclerView(rv_job_application_list)



        val deleteSwipeHandler = object : SwipeToDeleteCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val adapter = rv_job_application_list?.adapter as JobApplicationAdapter
                adapter.removeAt(viewHolder.adapterPosition)

            }
        }
        val deleteItemTouchHelper = ItemTouchHelper(deleteSwipeHandler)
        deleteItemTouchHelper.attachToRecyclerView(rv_job_application_list)

    }

    companion object {
        private const val ADD_PLACE_ACTIVITY_REQUEST_CODE = 1
        internal const val EXTRA_PLACE_DETAILS = "extra_place_details"
    }
}