package com.nut.cdev.resistorcalculatorandroid.adapter.recyclerview

open class BaseItemViewType {
    var type = 0
    var groupId = 0
    var isShowSkeleton = true

    constructor(type: Int) {
        this.type = type
    }

    constructor(type: Int, groupId: Int) {
        this.type = type
        this.groupId = groupId
    }

    constructor(type: Int, isShowSkeleton: Boolean) {
        this.type = type
        this.isShowSkeleton = isShowSkeleton
    }
}
