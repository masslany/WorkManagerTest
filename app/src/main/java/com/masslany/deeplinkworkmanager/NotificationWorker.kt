package com.masslany.deeplinkworkmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(private val appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        val id = inputData.getString("id") ?: ""
        val name = inputData.getString("name") ?: ""

        val notificationHelper = NotificationHelper(appContext)

        notificationHelper.sendNotification(id, name)

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}