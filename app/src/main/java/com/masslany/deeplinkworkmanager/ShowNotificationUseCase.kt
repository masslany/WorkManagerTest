package com.masslany.deeplinkworkmanager

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import androidx.work.workDataOf
import java.util.*
import java.util.concurrent.TimeUnit

class ShowNotificationUseCase(
    private val workManager: WorkManager
) {

    fun execute(launchEntity: LaunchEntity) {
        val notificationRequest: WorkRequest =
            OneTimeWorkRequestBuilder<NotificationWorker>()
                .setInitialDelay(10, TimeUnit.SECONDS)
                .addTag(launchEntity.id)
                .setInputData(workDataOf(
                    "id" to launchEntity.id,
                    "name" to launchEntity.name
                ))
                .build()

        workManager.enqueue(notificationRequest)
    }

}