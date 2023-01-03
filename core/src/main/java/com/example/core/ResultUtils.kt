package com.example.core

inline fun <reified R> ResultOf<R>.doIfSuccess(callback: (value: R) -> Unit) {
    if (this is ResultOf.Success) {
        callback(data)
    }
}

inline fun <reified T> ResultOf<T>.doIfFailure(callback: (exception: Exception) -> Unit) {
    if (this is ResultOf.Error) {
        callback(exception)
    }
}

inline fun <reified T, reified R> ResultOf<T>.map(transform: (T) -> R): ResultOf<R> {
    return when (this) {
        is ResultOf.Success -> ResultOf.Success(transform(data))
        is ResultOf.Error -> this
    }
}

inline fun <T> ResultOf<T>.withDefault(value: () -> T): ResultOf.Success<T> {
    return when (this) {
        is ResultOf.Success -> this
        is ResultOf.Error -> ResultOf.Success(value())
    }
}