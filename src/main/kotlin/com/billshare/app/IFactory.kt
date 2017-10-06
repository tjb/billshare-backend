package com.billshare.app

interface IFactory <in Input1, in Input2, out Output> {
    fun create(source1: Input1?, source2: Input2?): Output
}



