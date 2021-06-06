package com.stockup.services

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.stockup.data.Device
import com.stockup.mqtt.MQTTPublisher
import com.stockup.repositories.DeviceRepository
import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject

@ApplicationScoped
class DeviceService {

    @Inject
    @field: Default
    lateinit var mqttClient: MQTTPublisher

    @Inject
    @field: Default
    lateinit var deviceRepository: DeviceRepository

    init {
        mqttClient.setCallback(object : MqttCallback {
            override fun messageArrived(topic: String?, message: MqttMessage?) {
                if (topic!!.toString() == mqttClient.deviceShelfRequestTopic) {
                    val map: Map<String, Any> = jacksonObjectMapper().readValue(message.toString())
                    val deviceID: String = map["deviceID"].toString()
                    mqttClient.sendDeviceShelves(deviceID, MqttMessage())
                }
            }

            override fun connectionLost(cause: Throwable?) {
            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {
            }
        })
    }

    fun getDevices(): Multi<Device> {
        return deviceRepository.getDevices()
    }

    fun getDeviceWithId(deviceId: String): Uni<Device?> {
        return deviceRepository.getDevice(deviceId)
    }

    fun addDevice(device: Device): Uni<Void> {
        return deviceRepository.addDevice(device)
    }

    fun addDeviceToSector(deviceId: String, sectorId: String): Uni<Void> {
        return Uni.createFrom().nullItem()
    }

    fun addRacksToManage(deviceId: String, rackId: String): Uni<Void> {
        return Uni.createFrom().nullItem()
    }

    fun removeShelfFromDevice(deviceId: String, shelfId: String): Uni<Void> {
        return Uni.createFrom().nullItem()
    }

    fun deleteDevice(deviceId: String): Uni<Boolean> {
        return deviceRepository.deleteDevice(deviceId)
    }
}