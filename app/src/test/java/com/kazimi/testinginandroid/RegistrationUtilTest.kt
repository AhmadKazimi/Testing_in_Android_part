package com.kazimi.testinginandroid

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `if user name is empty return false`() {

        val result = RegistrationUtil.validateRegistrationInput(
            "",
            password = "1234",
            confirmedPassword = "1234"
        )

        assertThat(result).isFalse()
    }


    @Test
    fun `valid user name and correctly repeated password return true`() {

        val result = RegistrationUtil.validateRegistrationInput(
            "Ahmad",
            password = "1234",
            confirmedPassword = "1234"
        )

        assertThat(result).isTrue()
    }


    @Test
    fun `user name already exist return false`() {

        val result = RegistrationUtil.validateRegistrationInput(
            "Kazimi",
            password = "1234",
            confirmedPassword = "1234"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `password is empty return false`() {

        val result = RegistrationUtil.validateRegistrationInput(
            "Ahmad",
            password = "",
            confirmedPassword = ""
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `password was repeated incorrectly return false`() {

        val result = RegistrationUtil.validateRegistrationInput(
            "Ahmad",
            password = "Abcabc",
            confirmedPassword = "123123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `password contain less than 2 digit return false`() {

        val result = RegistrationUtil.validateRegistrationInput(
            "Ahmad",
            password = "Abcabc1",
            confirmedPassword = "Abcabc1"
        )

        assertThat(result).isFalse()
    }
}