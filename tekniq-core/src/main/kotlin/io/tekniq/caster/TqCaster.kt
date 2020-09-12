package io.tekniq.caster

import java.lang.StringBuilder
import java.net.InetAddress
import java.net.MulticastSocket

class TqCaster(val host: String = "229.3.5.7", val port: Int = 6942) {
    private val group = InetAddress.getByName(host)
    private val socket = MulticastSocket(port)

    fun join() {
        socket.joinGroup(group)
    }

    fun leave() {
        socket.leaveGroup(group)
    }
}

data class TqCastMessage(val topic: String, val data: String? = null, val headers: Map<String, String> = emptyMap()) {
    override fun toString(): String {
        val sb = StringBuilder(topic)
        headers.forEach { (header, value) -> sb.append("$header:$value") }
        sb.appendln()
        data?.also { sb.append(data) }
        sb.append(0)
        return sb.toString()
    }
}
