package com.im.im.extentions

/**
 * Created by hameisi on 18/3/29.
 */
fun String.isValidUserName():Boolean = this.matches(Regex("^[a-zA-Z]\\w{2,19}$"))
fun String.isValidPassWorld():Boolean = this.matches(Regex("^[0-9]{3,20}$"))