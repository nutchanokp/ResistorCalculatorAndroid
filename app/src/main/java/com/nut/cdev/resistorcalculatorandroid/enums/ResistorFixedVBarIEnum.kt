package com.nut.cdev.resistorcalculatorandroid.enums

import com.nut.cdev.resistorcalculatorandroid.R

enum class ResistorFixedVBarIEnum(val color: Int, val barImage: Int, val value: Int) {
    BLACK(R.drawable.selector_btn_black,  R.drawable.r4_c1_black,0),
    BROWN(R.drawable.selector_btn_brown,  R.drawable.r4_c1_brown,100),
    RED(R.drawable.selector_btn_red,  R.drawable.r4_c1_red,200),
    ORANGE(R.drawable.selector_btn_orange,  R.drawable.r4_c1_orange,300),
    YELLOW(R.drawable.selector_btn_yellow,  R.drawable.r4_c1_yellow,400),
    GREEN(R.drawable.selector_btn_green,  R.drawable.r4_c1_green,500),
    BLUE(R.drawable.selector_btn_blue,  R.drawable.r4_c1_blue,600),
    VIOLET(R.drawable.selector_btn_violet, R.drawable.r4_c1_violet, 700),
    GREY(R.drawable.selector_btn_grey,  R.drawable.r4_c1_gray,800),
    WHITE(R.drawable.selector_btn_white,  R.drawable.r4_c1_white,900)
}