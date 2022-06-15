package com.kazimi.testinginandroid

object RegistrationUtil {

    private val existingUsers = listOf(
        "Kazimi",
        "Jone",
        "Adam"
    )

    fun validateRegistrationInput(
        userName: String,
        password: String,
        confirmedPassword: String
    ): Boolean {

        if (userName.isEmpty() || password.isEmpty())
            return false

        if (userName in existingUsers)
            return false

        if (password != confirmedPassword)
            return false

        if (password.count { it.isDigit() } < 2)
            return false

        return true
    }
}