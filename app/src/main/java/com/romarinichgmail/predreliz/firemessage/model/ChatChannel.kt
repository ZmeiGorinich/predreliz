package com.romarinichgmail.predreliz.firemessage.model


data class ChatChannel(val userIds: MutableList<String>) {
    constructor() : this(mutableListOf())
}