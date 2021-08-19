package com.example.tmm

import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 내 호선 recyclerView
        val myStationList = ArrayList<DataMyStation>()
        for (i in 1..10) {
            myStationList.add(DataMyStation(getDrawable(R.drawable.mystation_3)!!, "경복궁"))
        }

        // 단차 위험 호선 recyclerView
        val dangerList = ArrayList<DataDangerLine>()
        val dangerSubList = ArrayList<DataDangerSub>()

        for (i: Int in 1..5){
            dangerSubList.add(DataDangerSub("영등포역"))
        }

        val dangerLen: Int = 9
        for (i: Int in 1..dangerLen) {
            dangerList.add(DataDangerLine(getDrawable(R.drawable.line_1_select), "${i}호선", dangerSubList))
        }


        // 기본 화면 메인 프레그먼트 지정
        setFrag(0)
        intent.putExtra("MyStationList", myStationList)
        intent.putExtra("DangerList", dangerList)


        // edit text 클릭 시 검색 Fragment 이동
        editText.setOnTouchListener { _: View, event: MotionEvent ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    setFrag(1)
                }
            }
            true
        }

        // 이전 버튼 동작 추가가
        back_btn_main.setOnClickListener{
//            super.onBackPressed()
            setFrag(0)
        }
    }
    private fun setFrag(fragNum: Int) {
        val ft = supportFragmentManager.beginTransaction()
        when (fragNum) {
            0 -> {
                ft.replace(R.id.main_frame, MainFragment()).commit()
            }
            1 -> {
                ft.replace(R.id.main_frame, SearchFragment()).commit()
            }
        }
    }
}