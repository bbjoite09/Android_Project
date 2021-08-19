package com.example.tmm

import android.graphics.drawable.Drawable

class DataDangerLine(
    val lineImg:Drawable?,
    val lineName:String,
    val dangerSub : ArrayList<DataDangerSub>,
    var isExpanded: Boolean = false,
//    val dangerSub: MutableList<DataDangerSub>
    ) {}