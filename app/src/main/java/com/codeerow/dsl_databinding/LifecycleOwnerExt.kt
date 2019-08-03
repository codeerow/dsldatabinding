package com.codeerow.dsl_databinding

import androidx.lifecycle.LifecycleOwner


fun LifecycleOwner.databinding(form: DataBinding.() -> Unit) {
    val dataBinding = DataBinding(this)
    form(dataBinding)
}