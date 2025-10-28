package org.ghibli_wiki.utilities

class LoggerUtility {

    private val logger: System.Logger = System.getLogger(this::class.java.name)

    fun logInfo(msg: String) {
        return logger.log(System.Logger.Level.INFO, msg)
    }

    fun logAll(msg: String) {
        return logger.log(System.Logger.Level.ALL, msg)
    }

    fun logOff(msg: String) {
        return logger.log(System.Logger.Level.OFF, msg)
    }

    fun logDebug(msg: String) {
        return logger.log(System.Logger.Level.DEBUG, msg)
    }

    fun logError(msg: String) {
        return logger.log(System.Logger.Level.ERROR, msg)
    }

    fun logTrace(msg: String) {
        return logger.log(System.Logger.Level.TRACE, msg)
    }

    fun logWarning(msg: String) {
        return logger.log(System.Logger.Level.WARNING, msg)
    }

}