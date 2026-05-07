package ru.testmirrorartifacts.second

internal object Tes {

    init {
        System.loadLibrary("tes")
    }

    external fun tes()
}

fun tes() = Tes.tes()
