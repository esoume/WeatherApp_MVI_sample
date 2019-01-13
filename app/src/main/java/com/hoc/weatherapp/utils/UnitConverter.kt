package com.hoc.weatherapp.utils

import com.hoc.weatherapp.data.models.apiresponse.PressureUnit
import com.hoc.weatherapp.data.models.apiresponse.PressureUnit.HPA
import com.hoc.weatherapp.data.models.apiresponse.PressureUnit.MM_HG
import com.hoc.weatherapp.data.models.apiresponse.SpeedUnit
import com.hoc.weatherapp.data.models.apiresponse.SpeedUnit.*
import com.hoc.weatherapp.data.models.apiresponse.TemperatureUnit
import com.hoc.weatherapp.data.models.apiresponse.TemperatureUnit.*

object UnitConverter {
  /**
   * Convert [temperatureInKelvin] from [KELVIN] to [to]
   */
  fun convertTemperature(temperatureInKelvin: Double, to: TemperatureUnit): Double {
    return when (to) {
      KELVIN -> temperatureInKelvin
      CELSIUS -> temperatureInKelvin - 272.15
      FAHRENHEIT -> temperatureInKelvin * 9.0 / 5 - 459.67
    }
  }

  /**
   * Convert [speedInMetersPerSecond] from [METERS_PER_SECOND] to [to]
   */
  fun convertSpeed(speedInMetersPerSecond: Double, to: SpeedUnit): Double {
    return when (to) {
      METERS_PER_SECOND -> speedInMetersPerSecond
      KILOMETERS_PER_HOUR -> 3.6 * speedInMetersPerSecond
      MILES_PER_HOUR -> 2.23693629 * speedInMetersPerSecond
    }
  }

  /**
   * Convert [pressureIn_hPa] from [HPA] to [to]
   */
  fun convertPressure(pressureIn_hPa: Double, to: PressureUnit): Double {
    return when (to) {
      HPA -> pressureIn_hPa
      MM_HG -> pressureIn_hPa * 0.75006157584566
    }
  }
}