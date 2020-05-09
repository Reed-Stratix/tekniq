package io.tekniq.schedule

class TqStopWatch(private val context: Any? = null) {
    private val markers = mutableMapOf("" to System.currentTimeMillis())

    fun reset() {
        markers.clear()
        markers[""] = System.currentTimeMillis()
    }

    fun mark(marker: String) {
        if (marker.isEmpty()) throw IllegalStateException("Marker cannot be an empty string")
        markers[marker] = System.currentTimeMillis()
    }

    fun elapse(marker: String = "", action: (markerDurationInMs: Long, context: Any?) -> Unit) {
        val start = markers[marker] ?: throw IllegalStateException("Undefined marker '$marker'")
        action(System.currentTimeMillis() - start, context)
    }
}

