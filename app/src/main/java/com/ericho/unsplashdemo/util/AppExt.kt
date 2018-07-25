package com.ericho.unsplashdemo.util

import com.ericho.unsplashdemo.data.Result

inline fun <T : Any, R : Any> Result<T>.mapOnSuccess(map: (T) -> R) = when (this) {
    is Result.Success -> Result.Success(map(data))
    is Result.Failure -> this
}
inline fun <T : Any> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Result.Success) action(data)

    return this
}

inline fun <T : Any> Result<T>.onError(action: (Throwable) -> Unit) {
    if (this is Result.Failure && error != null) action(error)
}