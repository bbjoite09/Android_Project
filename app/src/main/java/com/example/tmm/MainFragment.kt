package com.example.tmm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment() {
    // RecyclerView.adapter에 지정할 Adapter
    private lateinit var stationListAdapter: RecyclerAdapterMyStation
    private lateinit var dangerListAdapter: RecyclerAdapterDanger

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // myStation 리사이클러뷰
        super.onViewCreated(view, savedInstanceState)

        val myStationList: ArrayList<DataMyStation> = requireActivity().intent!!.extras!!.get("MyStationList") as ArrayList<DataMyStation>

        stationListAdapter = RecyclerAdapterMyStation(myStationList)

        my_station_list.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        my_station_list.adapter = stationListAdapter


        // ------------------------------------------------
        //dangerList 리사이클러뷰
        val dangerList: ArrayList<DataDangerLine> = requireActivity().intent!!.extras!!.get("DangerList") as ArrayList<DataDangerLine>

        dangerListAdapter = RecyclerAdapterDanger(dangerList)

        danger_line_list.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        danger_line_list.adapter = dangerListAdapter
    }
}
