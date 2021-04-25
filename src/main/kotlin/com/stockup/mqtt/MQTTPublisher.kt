package com.stockup.mqtt

import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage


class MQTTPublisher {

    val client: MqttClient = MqttClient("", "")
    private val indicateContainerLocationTopic: String = "indicateLocation"
    private val indicateContainerEmptyTopic: String = "indicateEmpty"

    init {
        try {
            val connOpts = MqttConnectOptions()
            connOpts.isCleanSession = true
            client.connect(connOpts)
        } catch (ex: Exception) {

        }
    }

    fun sendContainerLocation(deviceID: String, shelf: Int, container: Int) {
        val message = MqttMessage("".encodeToByteArray())
        message.qos = 2
        client.publish(indicateContainerLocationTopic, message)
    }

    fun sendContainerLowStock() {
        val message = MqttMessage("".encodeToByteArray())
        message.qos = 2
        client.publish(indicateContainerLocationTopic, message)
    }
}