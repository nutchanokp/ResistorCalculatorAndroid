package com.nut.cdev.resistorcalculatorandroid.enums

import com.nut.cdev.resistorcalculatorandroid.R

enum class ResistorFixedVBarIVEnum(
    val color: Int,
    val barImage: Int,
    val value: Int,
    val valuePower: Int
) {
    BLACK(R.drawable.selector_btn_black, R.drawable.r5_c4_black, 1, 0),
    BROWN(R.drawable.selector_btn_brown, R.drawable.r5_c4_brown, 10, 1),
    RED(R.drawable.selector_btn_red, R.drawable.r5_c4_red, 10, 2),
    ORANGE(R.drawable.selector_btn_orange, R.drawable.r5_c4_orange, 10, 3),
    YELLOW(R.drawable.selector_btn_yellow, R.drawable.r5_c4_yellow, 10, 4),
    GREEN(R.drawable.selector_btn_green, R.drawable.r5_c4_green, 10, 5),
    BLUE(R.drawable.selector_btn_blue, R.drawable.r5_c4_blue, 10, 6),
    VIOLET(R.drawable.selector_btn_violet, R.drawable.r5_c4_violet, 10, 7),
    GREY(R.drawable.selector_btn_grey, R.drawable.r5_c4_grey , 10, 8),
    WHITE(R.drawable.selector_btn_white, R.drawable.r5_c4_white, 10, 9)
}