package com.nut.cdev.resistorcalculatorandroid.enums

import com.nut.cdev.resistorcalculatorandroid.R

enum class ResistorFixedVIBarIIEnum(val color: Int, val barImage : Int, val value: Int) {
    BLACK(R.drawable.selector_btn_black,  R.drawable.r6_c2_black,0),
    BROWN(R.drawable.selector_btn_brown,  R.drawable.r6_c2_brown,10),
    RED(R.drawable.selector_btn_red,  R.drawable.r6_c2_red,20),
    ORANGE(R.drawable.selector_btn_orange,  R.drawable.r6_c2_orange,30),
    YELLOW(R.drawable.selector_btn_yellow,  R.drawable.r6_c2_yellow,40),
    GREEN(R.drawable.selector_btn_green,  R.drawable.r6_c2_green,50),
    BLUE(R.drawable.selector_btn_blue,  R.drawable.r6_c2_blue,60),
    VIOLET(R.drawable.selector_btn_violet, R.drawable.r6_c2_violet, 70),
    GREY(R.drawable.selector_btn_grey,  R.drawable.r6_c2_gray,80),
    WHITE(R.drawable.selector_btn_white,  R.drawable.r6_c2_white,90)
}