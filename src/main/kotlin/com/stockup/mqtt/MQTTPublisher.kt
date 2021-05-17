package com.stockup.mqtt

import io.quarkus.runtime.Startup
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage
import javax.enterprise.context.ApplicationScoped

@Startup
@ApplicationScoped
class MQTTPublisher {

    @ConfigProperty(name = "mqtt.serveruri")
    final val serverURI: String = ""

    @ConfigProperty(name = "mqtt.clientid")
    final val clientID: String = ""

    private val client: MqttClient = MqttClient(serverURI, clientID)
    private val indicateContainerLocationTopic: String = "indicateLocation"
    private val indicateContainerEmptyTopic: String = "indicateEmpty"

    init {
        try {
            val connOpts = MqttConnectOptions()
            connOpts.isCleanSession = true
            client.connect(connOpts)
            client.subscribe("/devices/requestDeviceShelves")
        } catch (ex: Exception) {
        }
    }

    fun indicateContainerLocationWithBlink(
        sectorId: String,
        rackId: String,
        shelf_id: String,
        containerIndex: Int,
        blinkDuration: Int
    ) {
        return indicateContainerLocation(sectorId, rackId, shelf_id, containerIndex, "blink", blinkDuration)
    }

    fun indicateContainerLocationBlinkingIntervals(
        sectorId: String,
        rackId: String,
        shelf_id: String,
        containerIndex: Int,
        blinkInterval: Int
    ) {
        return indicateContainerLocation(sectorId, rackId, shelf_id, containerIndex, "blink_interval", blinkInterval)
    }

    fun indicateContainerLocationStatic(
        sectorId: String,
        rackId: String,
        shelf_id: String,
        containerIndex: Int,
        showDuration: Int
    ) {
        return indicateAtTopic(
            "/sector/${sectorId}/rack/${rackId}/shelf/${shelf_id}/${indicateContainerLocationTopic}",
            containerIndex,
            "static",
            showDuration
        )
    }

    fun indicateContainerLocation(
        sectorId: String,
        rackId: String,
        shelf_id: String,
        containerIndex: Int,
        showType: String? = "static",
        showDuration: Int? = -1
    ) {
        return indicateAtTopic(
            "/sector/${sectorId}/rack/${rackId}/shelf/${shelf_id}/${indicateContainerLocationTopic}",
            containerIndex,
            showType,
            showDuration
        )
    }

    fun turnOffIndicator(
        sectorId: String,
        rackId: String,
        shelf_id: String,
        containerIndex: Int,
    ) {
        return indicateAtTopic(
            "/sector/${sectorId}/rack/${rackId}/shelf/${shelf_id}/${indicateContainerLocationTopic}",
            containerIndex,
            "off",
            -1
        )
    }

    fun indicateContainerEmpty(
        sectorId: String,
        rackId: String,
        shelf_id: String,
        containerIndex: Int,
        showType: String?,
        showDuration: Int?
    ) {
        return indicateAtTopic(
            "/sector/${sectorId}/rack/${rackId}/shelf/${shelf_id}/${indicateContainerEmptyTopic}",
            containerIndex,
            showType,
            showDuration
        )
    }

    fun indicateAtTopic(
        topic: String,
        containerIndex: Int,
        showType: String? = "blink", //blink = blink once; blink_interval = blink in intervals till it is turned off; static = the LED stays on till it is turned off
        showDuration: Int? = -1 // -1 means turned on till turned off, 0 and beyond is either interval or duration
    ) {
        val message =
            MqttMessage("{container: ${containerIndex}, showType: ${showType}, showDuration: ${showDuration}, color: { r:${""}, g:${""}, b:${""} }}".encodeToByteArray())
        message.qos = 2
        client.publish(topic, message)
    }
}