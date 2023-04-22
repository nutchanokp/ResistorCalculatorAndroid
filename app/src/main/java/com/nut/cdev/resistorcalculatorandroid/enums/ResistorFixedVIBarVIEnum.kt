package com.nut.cdev.resistorcalculatorandroid.enums

import com.nut.cdev.resistorcalculatorandroid.R

enum class ResistorFixedVIBarVIEnum(val color: Int, val barImage: Int, val value: Int) {
    BLACK(R.drawable.selector_btn_black,  R.drawable.r6_c6_black,250),
    BROWN(R.drawable.selector_btn_brown,  R.drawable.r6_c6_brown,100),
    RED(R.drawable.selector_btn_red,  R.drawable.r6_c6_red,50),
    ORANGE(R.drawable.selector_btn_orange,  R.drawable.r6_c6_orange,15),
    YELLOW(R.drawable.selector_btn_yellow,  R.drawable.r6_c6_yellow,25),
    GREEN(R.drawable.selector_btn_green,  R.drawable.r6_c6_green,20),
    BLUE(R.drawable.selector_btn_blue,  R.drawable.r6_c6_blue,10),
    VIOLET(R.drawable.selector_btn_violet, R.drawable.r6_c6_violet, 5),
    GREY(R.drawable.selector_btn_grey,  R.drawable.r6_c6_grey,1)
}