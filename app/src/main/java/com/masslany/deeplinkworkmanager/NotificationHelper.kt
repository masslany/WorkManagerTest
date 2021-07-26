package com.masslany.deeplinkworkmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService

class NotificationHelper(
    private val context: Context
) {
    companion object {

        const val CHANNEL_ID = "notif_channel"

        /**
         * Because you must create the notification channel before posting any notifications on Android 8.0 and higher,
         * you should execute this code as soon as your app starts.
         * It's safe to call this repeatedly because creating an existing notification channel performs no operation.
         * */

        fun createNotificationChannel(context: Context) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = context.getString(R.string.channel_name)
                val descriptionText = context.getString(R.string.channel_description)
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                // Register the channel with the system
                val notificationManager: NotificationManager =
                    getSystemService(context, NotificationManager::class.java) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }
        }
    }

    fun sendNotification(id: String, name: String) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(name)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(id, 0, builder.build())
        }

    }

}