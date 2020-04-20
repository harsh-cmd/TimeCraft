package com.demo.timecraft.ui.home.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.timecraft.R
import com.demo.timecraft.model.*
import com.demo.timecraft.ui.home.adapter.RecycleViewTodayTaskAdapter
import com.demo.timecraft.ui.home.adapter.callBackBottomSheet
import kotlinx.android.synthetic.main.home_fragment_task_detail.*

class TaskDetailFragment : Fragment(), callBackBottomSheet {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment_task_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val recycleViewTodayTaskAdapter =
            RecycleViewTodayTaskAdapter(getList(), this)
        recycleViewTask.apply {
            adapter = recycleViewTodayTaskAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    private fun getList(): ArrayList<Any> {
        val list = ArrayList<Any>()
        list.add(Label("Someday"))
        list.add(Task("data data data", getString(R.string.label_date)))
        list.add(Task("data ,data ,data", getString(R.string.label_date)))
        list.add(ScheduleMeetingTask("data data data", getString(R.string.label_date), 12, 36))
        list.add(
            TripTask(
                getString(R.string.label_international_trip),
                getString(R.string.demmy_trip_message),
                getString(R.string.label_date),
                getString(R.string.label_task_add_person_name),
                "12",
                "36"
            )
        )
        list.add(
            MeetingLocationTask(
                "day day dat",
                getString(R.string.label_date),
                "26",
                getString(R.string.label_address),
                getString(R.string.label_distance)
            )
        )
        list.add(AppointmentTask("data", "data", getString(R.string.label_date)))
        list.add(Label("Today"))
        list.add(AppointmentTask("data", "data", getString(R.string.label_date)))
        return list
    }

    override fun replaceBottomSheetFragment() {
        val bottomSheet = BottomSheetFragment()
        bottomSheet.show(childFragmentManager, "")
    }
}
