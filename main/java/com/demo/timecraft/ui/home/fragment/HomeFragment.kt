package com.demo.timecraft.ui.home.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.timecraft.R
import com.demo.timecraft.model.Days
import com.demo.timecraft.ui.base.BaseFragment
import com.demo.timecraft.ui.home.adapter.RecycleViewDaysAdapter
import kotlinx.android.synthetic.main.home_fragment_home.*

class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment_home, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycleViewDays.apply {
            adapter = RecycleViewDaysAdapter(dayList())
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        }
        replaceFragment()
    }

    private fun dayList(): ArrayList<Days> {
        val list = ArrayList<Days>()
        list.add(Days("Mon", "01"))
        list.add(Days("Today", "02"))
        list.add(Days("Tomorrow", "03"))
        list.add(Days("Thu", "04"))
        list.add(Days("Fri", "05"))
        return list
    }

    private fun replaceFragment() {
        val beginTransaction = childFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.placeHolder, TaskDetailFragment())
        beginTransaction.commit()
    }
}
