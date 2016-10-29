package io.tekniq.config

open class TqMapConfig(private val values: Map<String, Any>) : TqConfig() {
    @Suppress("UNCHECKED_CAST")
    override fun <T> getValue(key: String, type: Class<T>?): T? = values[key] as T
}
