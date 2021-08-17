package com.example.tmm

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        //---------------------------------------------------------------------------------------------------
        // 내 호선 recyclerView


        val myStationList = ArrayList<DataMyStation>()


        for(i in 1..10){
            myStationList.add(DataMyStation(getDrawable(R.drawable.mystation_3)!!, "경복궁"))
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
            dangerList.add(DataDangerLine(getDrawable(R.drawable.line_1_select),"${i}호선"))
        }

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter2 = RecyclerAdapterDanger(dangerList)
        recyclerView.adapter = adapter2


        val dangerAdapter = RecyclerAdapterDanger(dangerList)
        danger_line_list.adapter = dangerAdapter

        return view
    }
}
