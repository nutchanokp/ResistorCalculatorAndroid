package com.nut.cdev.resistorcalculatorandroid.enums

import com.nut.cdev.resistorcalculatorandroid.R

enum class ResistorColorEnum(val color: Int? = null, val value: Int) {
    BLACK(R.drawable.selector_btn_black, 0),
    BROWN(R.drawable.selector_btn_brown, 0),
    RED(R.drawable.selector_btn_red, 0),
    ORANGE(R.drawable.selector_btn_orange, 0),
    YELLOW(R.drawable.selector_btn_yellow, 0),
    GREEN(R.drawable.selector_btn_green, 0),
    BLUE(R.drawable.selector_btn_blue, 0),
    VIOLET(R.drawable.selector_btn_violet, 0),
    GREY(R.drawable.selector_btn_grey, 0),
    WHITE(R.drawable.selector_btn_white, 0),
    GOLD(null, 0),
    SILVER(null, 0),
    NONE(null, 0);
}