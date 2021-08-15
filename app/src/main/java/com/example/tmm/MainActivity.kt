package com.example.tmm

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //---------------------------------------------------------------------------------------------------
        // 내 호선 recyclerView
        val myStationList = ArrayList<DataMyStation>()


        for(i in 1..10){
            myStationList.add(DataMyStation(getDrawable(R.drawable.line3_checked)!!, "경복궁"))
        }

        val myStationAdapter = RecyclerAdapterMyStation(myStationList)
        my_station_list.adapter = myStationAdapter


        // 틈 정보 페이지 이동
        info_button.setOnClickListener{
            val intentInfo = Intent(this, TmmInfoActivity::class.java)
            startActivity(intentInfo)
        }

        //---------------------------------------------------------------------------------------------------
        // 단차 위험 호선 recyclerView
        val dangerList = ArrayList<DataDangerLine>()
        var adapter2: RecyclerAdapterDanger
        val recyclerView = findViewById<RecyclerView>(R.id.danger_line_list)

        val dangerLen: Int = 9
        for(i: Int in 1..dangerLen){
            dangerList.add(DataDangerLine(getDrawable(R.drawable.line1_checked),"${i}호선"))
        }

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter2 = RecyclerAdapterDanger(dangerList)
        recyclerView.adapter = adapter2


        val dangerAdapter = RecyclerAdapterDanger(dangerList)
        danger_line_list.adapter = dangerAdapter

    }
}