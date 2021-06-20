package com.stockup.mqtt

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.quarkus.runtime.Startup
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.paho.client.mqttv3.*
import javax.enterprise.context.ApplicationScoped

@Startup
@ApplicationScoped
class MQTTPublisher {

    @ConfigProperty(name = "mqtt.client.brokeruri")
    private val serverURI: String = ""

    @ConfigProperty(name = "mqtt.client.id")
    private val clientID: String = ""

    @ConfigProperty(name = "mqtt.indicate.color.default")
    private val indicateDefaultColor: Int = 0

    @ConfigProperty(name = "mqtt.indicate.color.empty")
    private val indicateEmptyColor: Int = 0

    @ConfigProperty(name = "mqtt.indicate.type.default")
    private val indicateTypeDefault: DisplayType = DisplayType.BLINK_INTERVAL

    private val client: MqttClient = MqttClient(serverURI, clientID)
    private val indicateContainerLocationTopic: String = "indicateLocation"
    private val indicateContainerEmptyTopic: String = "indicateEmpty"
    final val deviceShelfRequestTopic: String = "/devices/requestDeviceShelves"


    enum class DisplayType(val type: String) {
        BLINK("blink"),
        BLINK_INTERVAL("blinkInterval"),
        STATIC("static"),
        OFF("off")
    }

    init {
        ObjectMapper().registerKotlinModule()
        try {
            val connOpts = MqttConnectOptions()
            connOpts.isCleanSession = true
            client.connect(connOpts)
            client.subscribe(deviceShelfRequestTopic)
        } catch (ex: Exception) {
        }
    }

    fun sendDeviceShelves(deviceID: String, message: MqttMessage) {
        client.publish("/device/${deviceID}/deviceShelves", message)
    }

    fun setCallback(callback: MqttCallback) {
        client.setCallback(callback)
    }

    fun indicateContainerLocationWithBlink(
        sectorId: String,
        rackId: String,
        shelfId: String,
        containerIndex: Int,
        blinkDuration: Int
    ) {
        return indicateContainerLocation(sectorId, rackId, shelfId, containerIndex, DisplayType.BLINK, blinkDuration)
    }

    fun indicateContainerLocationBlinkingIntervals(
        sectorId: String,
        rackId: String,
        shelfId: String,
        containerIndex: Int,
        blinkInterval: Int
    ) {
        return indicateContainerLocation(
            sectorId,
            rackId,
            shelfId,
            containerIndex,
            DisplayType.BLINK_INTERVAL,
            blinkInterval
        )
    }

    fun indicateContainerLocationStatic(
        sectorId: String,
        rackId: String,
        shelfId: String,
        containerIndex: Int,
        showDuration: Int
    ) {
        return indicateAtTopic(
            "/sector/${sectorId}/rack/${rackId}/shelf/${shelfId}/${indicateContainerLocationTopic}",
            containerIndex,
            DisplayType.STATIC,
            showDuration,
            indicateDefaultColor
        )
    }

    fun indicateContainerLocation(
        sectorId: String,
        rackId: String,
        shelfId: String,
        containerIndex: Int,
        displayType: DisplayType,
        showDuration: Int? = -1
    ) {
        return indicateAtTopic(
            "/sector/${sectorId}/rack/${rackId}/shelf/${shelfId}/${indicateContainerLocationTopic}",
            containerIndex,
            displayType,
            showDuration,
            indicateDefaultColor
        )
    }

    fun turnOffIndicator(
        sectorId: String,
        rackId: String,
        shelfId: String,
        containerIndex: Int,
    ) {
        return indicateAtTopic(
            "/sector/${sectorId}/rack/${rackId}/shelf/${shelfId}/${indicateContainerLocationTopic}",
            containerIndex,
            DisplayType.OFF,
            -1
        )
    }

    fun indicateContainerEmpty(
        sectorId: String,
        rackId: String,
        shelfId: String,
        containerIndex: Int,
        displayType: DisplayType,
        displayDuration: Int?
    ) {
        return indicateAtTopic(
            "/sector/${sectorId}/rack/${rackId}/shelf/${shelfId}/${indicateContainerEmptyTopic}",
            containerIndex,
            displayType,
            displayDuration,
            indicateEmptyColor
        )
    }

    fun indicateAtTopic(
        topic: String,
        containerIndex: Int,
        displayType: DisplayType = MQTTPublisher.DisplayType.BLINK, //blink = blink once; blinkInterval = blink in intervals till it is turned off; static = the LED stays on till it is turned off
        showDuration: Int? = -1, // -1 means turned on till turned off, 0 and beyond is either interval or duration
        color: Int? = 0
    ) {
        val messageStructure: HashMap<String, Any> = hashMapOf()
        messageStructure["container"] = containerIndex
        messageStructure["displayType"] = displayType
        messageStructure["displayDuration"] = showDuration!!
        messageStructure["color"] = color!!
        val message =
            MqttMessage(jacksonObjectMapper().writeValueAsBytes(messageStructure))
        message.qos = 2
        try {
            client.publish(topic, message)
        } catch (exception: MqttPersistenceException) {
        }
    }
}