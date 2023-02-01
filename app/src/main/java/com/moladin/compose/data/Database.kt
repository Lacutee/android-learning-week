package com.moladin.compose.data

import android.os.Build
import androidx.annotation.RequiresApi

class Database private constructor() {

    companion object {
        val Instance by lazy {
            Database()
        }

        private val sources by lazy {
            carPrefilled
        }
    }

    fun insert(carName: String) {
        val existingData = sources.find { it.name == carName }
        val currentIndex = sources.size
        if (existingData == null) {
            sources.add(CarEntity(carId = currentIndex + 1, name = carName, ""))
        }
    }

    fun update(carEntity: CarEntity) {
        val toUpdate = sources.find { it.carId == carEntity.carId }
        val index = sources.indexOf(toUpdate)
        toUpdate?.let {
            sources[index] = it.copy(name = carEntity.name)
        }
    }

    fun delete(carId: Int) {
        val toDelete = sources.find { it.carId == carId }
        val index = sources.indexOf(toDelete)
        sources.removeAt(index)
    }

    fun getCarById(carId: Int) = sources.find { it.carId == carId }

    fun getCars(): List<CarEntity> = sources
}


private val carPrefilled = arrayListOf(
    CarEntity(1, "Mitsubishi Pajero Sport", "https://images.pexels.com/photos/170811/pexels-photo-170811.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(2, "Suzuki Karimun", "https://images.pexels.com/photos/210019/pexels-photo-210019.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(3, "Toyota Kijang Inova", "https://images.pexels.com/photos/116675/pexels-photo-116675.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(4, "Mitsubishi Kuda", "https://images.pexels.com/photos/1592384/pexels-photo-1592384.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(5, "Hyundai Ionic", "https://images.pexels.com/photos/707046/pexels-photo-707046.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(6, "EV Tesla 2.0", "https://images.pexels.com/photos/909907/pexels-photo-909907.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(7, "Suzuki Splash 2017", "https://images.pexels.com/photos/8060364/pexels-photo-8060364.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(8, "Honda Jazz Rs 2018", "https://images.pexels.com/photos/8134647/pexels-photo-8134647.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(9, "Suzuki Jimny 1993", "https://images.pexels.com/photos/13627443/pexels-photo-13627443.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(10, "Suzuki Jimmny 2020", "https://images.pexels.com/photos/9070622/pexels-photo-9070622.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1Z"),
    CarEntity(11, "Isuzu Panther", "https://images.pexels.com/photos/10876473/pexels-photo-10876473.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(12, "Mazda 2", "https://images.pexels.com/photos/9331804/pexels-photo-9331804.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(13, "Mercedes Benz", "https://images.pexels.com/photos/11101465/pexels-photo-11101465.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(14, "Alphard", "https://images.pexels.com/photos/13233506/pexels-photo-13233506.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
    CarEntity(15, "Toyota HiAce", "https://images.pexels.com/photos/9782840/pexels-photo-9782840.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
)