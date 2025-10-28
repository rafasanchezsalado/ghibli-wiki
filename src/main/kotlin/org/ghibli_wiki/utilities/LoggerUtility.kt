package org.ghibli_wiki.utilities

class LoggerUtility {

    private val logger: System.Logger = System.getLogger(this::class.java.name)

    fun logInfo(msg: String): Unit {
        return logger.log(System.Logger.Level.INFO, msg)
    }

    fun logAll(msg: String): Unit {
        return logger.log(System.Logger.Level.ALL, msg)
    }

    fun logOff(msg: String): Unit {
        return logger.log(System.Logger.Level.OFF, msg)
    }

    fun logDebug(msg: String): Unit {
        return logger.log(System.Logger.Level.DEBUG, msg)
    }

    fun logError(msg: String): Unit {
        return logger.log(System.Logger.Level.ERROR, msg)
    }

    fun logTrace(msg: String): Unit {
        return logger.log(System.Logger.Level.TRACE, msg)
    }

    fun logWarning(msg: String): Unit {
        return logger.log(System.Logger.Level.WARNING, msg)
    }

}