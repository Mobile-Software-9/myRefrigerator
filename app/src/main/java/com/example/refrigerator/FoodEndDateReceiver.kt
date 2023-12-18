package com.example.refrigerator

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat

class FoodEndDateReceiver : BroadcastReceiver() {

    lateinit var notificationManager: NotificationManager
    val NOTIFICATION_ID = 0
    val CHANNEL_ID = "notification_channel"
    var food = ""

    override fun onReceive(context: Context, intent: Intent) {
        food = intent.getStringExtra("food")!!

        notificationManager = context.getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager

        createNotificationChannel()
        deliverNotification(context)
    }

    // Notification 을 띄우기 위한 Channel 등록
    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                CHANNEL_ID, // 채널의 아이디
                "채널 이름입니다.", // 채널의 이름
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true) // 불빛
            notificationChannel.lightColor = Color.RED // 색상
            notificationChannel.enableVibration(true) // 진동 여부
            notificationChannel.description = "채널의 상세정보입니다." // 채널 정보
            notificationManager.createNotificationChannel(
                notificationChannel
            )
        }
    }

    private fun deliverNotification(context: Context){
        val contentIntent = Intent(context, MyFoodInfoActivity::class.java)  //이동할페이지 수정필요
        val contentPendingIntent = PendingIntent.getActivity(
            context,
            NOTIFICATION_ID, // requestCode
            contentIntent, // 알림 클릭 시 이동할 인텐트
            PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.sampleimg) // 아이콘
            .setContentTitle("냉장고를 부탁해") // 제목
            .setContentText("$food 가 상해가고 있어요!") // 내용
            .setContentIntent(contentPendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)

        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }
}