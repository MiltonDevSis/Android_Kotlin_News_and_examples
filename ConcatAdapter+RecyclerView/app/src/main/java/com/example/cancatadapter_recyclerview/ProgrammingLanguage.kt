package com.example.cancatadapter_recyclerview

import androidx.annotation.DrawableRes

data class ProgrammingLanguage(
        val name: String,
        val paradigm: String,
        @DrawableRes
        val logo: Int
)

val programmingLanguages = listOf(
        ProgrammingLanguage("Kotlin", "Orientação a Objetos, Funcional", R.drawable.ic_logo_kotlin),
        ProgrammingLanguage("Java", "Orientação a Objetos", R.drawable.ic_logo_java),
        ProgrammingLanguage("JavaScript", "Orientação a Objetos", R.drawable.ic_logo_javascript),
        ProgrammingLanguage("Swift", "Orientação a Objetos, Funcional", R.drawable.ic_logo_swift),
        ProgrammingLanguage("PHP", "Orientação a Objetos", R.drawable.ic_logo_php),
        ProgrammingLanguage("Python", "Orientação a Objetos", R.drawable.ic_logo_python),
        ProgrammingLanguage("C#", "Orientação a Objetos", R.drawable.ic_c_sharp)
)