package br.com.douglasmotta.room_coroutines.extensions

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.dismissError() {
    this.error = null
    this.isErrorEnabled = false
}