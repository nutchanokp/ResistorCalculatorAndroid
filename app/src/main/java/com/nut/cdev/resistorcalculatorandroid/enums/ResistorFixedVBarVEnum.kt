package com.nut.cdev.resistorcalculatorandroid.enums

import com.nut.cdev.resistorcalculatorandroid.R

enum class ResistorFixedVBarVEnum(
    val color: Int,
    val barImage: Int,
    val value: String
) {
    BROWN(R.drawable.selector_btn_brown, R.drawable.r4_c5_brown, "1"),
    RED(R.drawable.selector_btn_red, R.drawable.r4_c5_red, "2"),
    GREEN(R.drawable.selector_btn_green, R.drawable.r4_c5_green, "0.5"),
    BLUE(R.drawable.selector_btn_blue, R.drawable.r4_c5_blue, "0.25"),
    VIOLET(R.drawable.selector_btn_violet, R.drawable.r4_c5_violet, "0.1"),
    GREY(R.drawable.selector_btn_grey, R.drawable.r4_c5_grey, "0.05"),
    GOLD(R.drawable.selector_btn_gold, R.drawable.r4_c5_gold, "5"),
    SILVER(R.drawable.selector_btn_silver, R.drawable.r4_c5_silver, "10"),
    NONE(R.drawable.selector_btn_white, R.drawable.r4_c5_none, "20")
}