package com.example.primerapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

object LiveDataTestUtil {
    @Throws(InterruptedException::class)
    fun <T> getValue(liveData: LiveData<T>): T? {
        var data: T? = null
        val latch = CountDownLatch(1)

        val observer = Observer<T> {
            data = it
            latch.countDown()
        }

        liveData.observeForever(observer)

        // Esperar hasta que se obtenga el valor o pasen 2 segundos
        latch.await(2, TimeUnit.SECONDS)

        // Se remueve el observer para sacar las pérdidas de memoria
        liveData.removeObserver(observer)

        return data
    }
}