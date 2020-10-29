package com.wcc.supertrunfo

class Card2 (
    val vehicle: Vehicle,
    val driver: Driver,
    val player: Player
) {
    val label: String = "Card ${player.name}"
    val maxVelocity = setMaxVelocity()
    val accelerationTime = setAccelerationTime()
    val passengers = setPassengers()

    private fun setPassengers(): Int {
        return vehicle.passengers * (1 + driver.defensiveDriving)
    }


    private fun setAccelerationTime(): Int {
        TODO("Not yet implemented")
    }


    private fun setMaxVelocity(): Int {
        return 0
    }
}


