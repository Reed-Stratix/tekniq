package io.tekniq.schedule

class TqStopWatch(private val tag: String? = null) {
    private var start = System.currentTimeMillis()

    fun reset() {
        start = System.currentTimeMillis()
    }

    fun elapse(action: (durationInMs: Long, tag: String?) -> Unit) {
        action(System.currentTimeMillis() - start, tag)
    }
}

