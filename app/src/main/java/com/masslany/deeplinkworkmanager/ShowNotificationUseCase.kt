package com.masslany.deeplinkworkmanager

import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import androidx.work.workDataOf
import java.util.concurrent.TimeUnit

class ShowNotificationUseCase(
    // Todo: Hide behind facade maybe
    private val workManager: WorkManager
) {

    fun execute(launchEntity: LaunchEntity) {
        val notificationRequest: WorkRequest =
            OneTimeWorkRequestBuilder<NotificationWorker>()
                    // Todo: Calculate time to 1 hour before the event
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