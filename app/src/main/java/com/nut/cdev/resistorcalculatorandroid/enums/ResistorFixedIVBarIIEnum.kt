package com.nut.cdev.resistorcalculatorandroid.enums

import com.nut.cdev.resistorcalculatorandroid.R

enum class ResistorFixedIVBarIIEnum(val color: Int, val barImage : Int, val value: Int) {
    BLACK(R.drawable.selector_btn_black,  R.drawable.r4_c2_black,0),
    BROWN(R.drawable.selector_btn_brown,  R.drawable.r4_c2_brown,1),
    RED(R.drawable.selector_btn_red,  R.drawable.r4_c2_red,2),
    ORANGE(R.drawable.selector_btn_orange,  R.drawable.r4_c2_orange,3),
    YELLOW(R.drawable.selector_btn_yellow,  R.drawable.r4_c2_yellow,4),
    GREEN(R.drawable.selector_btn_green,  R.drawable.r4_c2_green,5),
    BLUE(R.drawable.selector_btn_blue,  R.drawable.r4_c2_blue,6),
    VIOLET(R.drawable.selector_btn_violet, R.drawable.r4_c2_violet, 7),
    GREY(R.drawable.selector_btn_grey,  R.drawable.r4_c2_gray,8),
    WHITE(R.drawable.selector_btn_white,  R.drawable.r4_c2_white,9)
}