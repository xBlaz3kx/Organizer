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

    final val client: MqttClient = MqttClient(serverURI, clientID)
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

    fun indicateContainerLocation(sectorId: String, rackId: String, shelf: Int, container: Int) {
        return indicateAtTopic(
            "/sector/${sectorId}/rack/${rackId}/${indicateContainerLocationTopic}",
            shelf,
            container
        )
    }

    fun indicateContainerEmpty(sectorId: String, rackId: String, shelf: Int, container: Int) {
        return indicateAtTopic(
            "/sector/${sectorId}/rack/${rackId}/${indicateContainerEmptyTopic}",
            shelf,
            container
        )
    }

    fun indicateAtTopic(topic: String, shelf: Int, container: Int) {
        val message = MqttMessage("{shelf:${shelf}, container: ${container}}".encodeToByteArray())
        message.qos = 2
        client.publish(topic, message)
    }
}