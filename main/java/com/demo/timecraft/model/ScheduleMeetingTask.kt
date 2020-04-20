package com.demo.timecraft.model

data class ScheduleMeetingTask(
    val meetingMessage: String,
    val date: String,
    val totalNumberOfPerson: Int,
    val numberOfComments: Int
)