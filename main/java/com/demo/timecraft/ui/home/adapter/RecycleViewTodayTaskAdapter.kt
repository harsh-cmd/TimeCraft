package com.demo.timecraft.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.demo.timecraft.R
import com.demo.timecraft.model.*
import com.demo.timecraft.ui.home.fragment.BottomSheetFragment


class RecycleViewTodayTaskAdapter(
    private val list: ArrayList<Any>,
    private val callBackBottomSheet: callBackBottomSheet
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val tag_layout = 0
    private val shedule_layout = 1
    private val meeting_location_layout = 2
    private val trip_layout = 3
    private val appointment_layout = 4
    private val label_layout = 5
    private val simple_task = 6


    class ViewHolderTask(v: View) : RecyclerView.ViewHolder(v), View.OnLongClickListener {
        val textViewMessage: AppCompatTextView
        val textViewDate: AppCompatTextView
        val constrainLayout: ConstraintLayout
        val constrainLayoutOptionMenu: ConstraintLayout

        init {
            textViewMessage = v.findViewById(R.id.textViewMessage)
            textViewDate = v.findViewById(R.id.textViewDate)
            constrainLayout = v.findViewById(R.id.constraintLayoutTask)
            constrainLayoutOptionMenu = v.findViewById(R.id.constrainLayoutOptionMenu)
            constrainLayout.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            constrainLayoutOptionMenu.visibility = View.VISIBLE
            return true
        }
    }

    class ViewHolderSimpleTask(v: View) : RecyclerView.ViewHolder(v), View.OnLongClickListener {
        val textViewMessage: AppCompatTextView
        val constraintLayout: ConstraintLayout
        val constraintLayoutOptionMenu: ConstraintLayout

        init {
            textViewMessage = v.findViewById(R.id.textViewMessage)
            constraintLayout = v.findViewById(R.id.constraintLayoutSimpleTask)
            constraintLayoutOptionMenu = v.findViewById(R.id.constrainLayoutOptionMenu)

            constraintLayout.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            constraintLayoutOptionMenu.visibility = View.VISIBLE
            return true
        }
    }

    class ViewHolderScheduleMeeting(v: View) : RecyclerView.ViewHolder(v),
        View.OnLongClickListener {
        val textViewMeetingMessage: AppCompatTextView
        val textViewDate: AppCompatTextView
        val constraintLayout: ConstraintLayout
        val constrainLayoutOptionMenu: ConstraintLayout


        init {
            textViewMeetingMessage = v.findViewById(R.id.textViewMeetingMessage)
            textViewDate = v.findViewById(R.id.textViewDate)
            constraintLayout =
                v.findViewById(R.id.constraintLayoutScheduleMeeting)
            constrainLayoutOptionMenu = v.findViewById(R.id.constrainLayoutOptionMenu)
            constraintLayout.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            constrainLayoutOptionMenu.visibility = View.VISIBLE
            return true
        }

    }

    class ViewHolderTrip(v: View) : RecyclerView.ViewHolder(v), View.OnLongClickListener {
        val textViewTripMessage: AppCompatTextView
        val textViewDate: AppCompatTextView
        val constrainLayout: ConstraintLayout
        val constrainLayoutOptionMenu: ConstraintLayout


        init {
            textViewTripMessage = v.findViewById(R.id.textViewTripMessage)
            textViewDate = v.findViewById(R.id.textViewDate)
            constrainLayout = v.findViewById(R.id.constraintLayoutTrip)
            constrainLayoutOptionMenu = v.findViewById(R.id.constrainLayoutOptionMenu)
            constrainLayout.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            constrainLayoutOptionMenu.visibility = View.VISIBLE
            return true
        }

    }

    class ViewHolderMeetingLocation(v: View) : RecyclerView.ViewHolder(v),
        View.OnLongClickListener {
        val textViewMeetingMessage: AppCompatTextView
        val textViewDate: AppCompatTextView
        val textViewAddress: AppCompatTextView
        val textViewDistance: AppCompatTextView
        val constrainLayout: ConstraintLayout
        val constraintLayoutOptionMenu: ConstraintLayout

        init {
            textViewMeetingMessage = v.findViewById(R.id.textViewMeetingMessage)
            textViewDate = v.findViewById(R.id.textViewDate)
            textViewAddress = v.findViewById(R.id.textViewAddress)
            textViewDistance = v.findViewById(R.id.textViewDistance)
            constrainLayout = v.findViewById(R.id.constraintLayoutMeetingLocation)
            constrainLayout.setOnLongClickListener(this)
            constraintLayoutOptionMenu = v.findViewById(R.id.constrainLayoutOptionMenu)
        }

        override fun onLongClick(v: View?): Boolean {
            constraintLayoutOptionMenu.visibility = View.VISIBLE
            return true
        }
    }

    class ViewHolderAppointment(
        v: View,
        private val callBackBottomSheet: callBackBottomSheet
    ) : RecyclerView.ViewHolder(v), View.OnLongClickListener,
        View.OnClickListener {
        val textViewShopName: AppCompatTextView
        val textViewAppointmentMessage: AppCompatTextView
        val textViewDate: AppCompatTextView
        val constrainLayout: ConstraintLayout
        val constraintLayoutOptionMenu: ConstraintLayout
        var isLongPress = false

        init {

            textViewShopName = v.findViewById<AppCompatTextView>(R.id.textViewShopName)
            textViewAppointmentMessage =
                v.findViewById(R.id.textViewAppointmentMessage)
            textViewDate = v.findViewById(R.id.textViewDate)
            constrainLayout = v.findViewById(R.id.constrainLayoutAppointment)
            constraintLayoutOptionMenu = v.findViewById(R.id.constrainLayoutOptionMenu)
            constrainLayout.setOnLongClickListener(this)
            constrainLayout.setOnClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            constraintLayoutOptionMenu.visibility = View.VISIBLE
            isLongPress = true
            return true
        }

        override fun onClick(v: View?) {
            if (!isLongPress) {
                val bottomSheetFragment = BottomSheetFragment()
                callBackBottomSheet.replaceBottomSheetFragment()
            }

        }

    }

    class ViewHolderTextView(v: View) : RecyclerView.ViewHolder(v) {
        val textViewDay = v.findViewById<AppCompatTextView>(R.id.textViewDay)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            tag_layout -> {
                return ViewHolderTask(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.raw_task_item_one,
                        parent,
                        false
                    )
                )
            }
            shedule_layout -> {
                return ViewHolderScheduleMeeting(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.raw_task_shedule_item,
                        parent,
                        false
                    )
                )
            }
            trip_layout -> {
                return ViewHolderTrip(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.raw_task_trip_item,
                        parent,
                        false
                    )
                )
            }
            meeting_location_layout -> {
                return ViewHolderMeetingLocation(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.raw_task_meeting_location_item,
                        parent,
                        false
                    )
                )
            }
            label_layout -> {
                return ViewHolderTextView(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.raw_task_text_view_item,
                        parent,
                        false
                    )
                )
            }
            simple_task -> {
                return ViewHolderTextView(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.raw_task_item_two,
                        parent,
                        false
                    )
                )
            }
            else -> {
                return ViewHolderAppointment(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.raw_task_appointment_item,
                        parent,
                        false
                    ), callBackBottomSheet
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderMeetingLocation -> {
                holder.apply {
                    (list[position] as MeetingLocationTask).apply {
                        textViewDate.text = date
                        textViewAddress.text = meetingAddress
                        textViewDistance.text = distance
                        textViewMeetingMessage.text = meetingMessage
                    }
                }
            }

            is ViewHolderAppointment -> {

                holder.apply {
                    (list[position] as AppointmentTask).apply {
                        textViewAppointmentMessage.text = message
                        textViewDate.text = date
                        textViewShopName.text = shopName
                    }
                }
            }

            is ViewHolderTrip -> {
                holder.apply {
                    (list[position] as TripTask).apply {
                        textViewDate.text = date
                        textViewTripMessage.text = tripMessage
                    }
                }
            }

            is ViewHolderScheduleMeeting -> {
                holder.apply {
                    (list[position] as ScheduleMeetingTask).apply {
                        textViewDate.text = date
                        textViewMeetingMessage.text = meetingMessage
                    }
                }
            }

            is ViewHolderTask -> {
                holder.apply {
                    (list[position] as Task).apply {
                        textViewDate.text = date
                        textViewMessage.text = taskDetail
                    }
                }

            }

            is ViewHolderTextView -> {
                holder.apply {
                    textViewDay.text = (list[position] as Label).name
                }
            }

            is ViewHolderSimpleTask -> {
                holder.textViewMessage.text = (list[position] as SimpleTask).message
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Label -> {
                label_layout
            }
            is AppointmentTask -> {

                appointment_layout
            }
            is Task -> {

                tag_layout
            }
            is ScheduleMeetingTask -> {

                shedule_layout
            }
            is TripTask -> {

                trip_layout
            }
            is SimpleTask -> {
                simple_task
            }
            else -> {
                meeting_location_layout
            }
        }
    }
}

interface callBackBottomSheet {
    fun replaceBottomSheetFragment()
}

