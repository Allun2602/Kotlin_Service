package com.example.service_kotlin

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {


    override fun onCreate() {
        super.onCreate()

        Thread{  //使用Thread執行耗時任務
            try {
                Thread.sleep(3000)//延遲3秒
                //宣告Intent，從MService啟動Activity
                val intent = Intent(this, SecActivity::class.java)
                //加入Flag表示要產生一個新的Activity
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }.start()
    }


    override fun onStartCommand(intent: Intent,flags: Int, startid: Int): Int{

        return  START_NOT_STICKY  //Service終止後不再做
    }



    override fun onBind(intent: Intent): IBinder? = null

}