package com.itsfrz.testingdemo


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityTest {

    val main = MainActivity()

    @Test
    fun validate_username_empty_return_false(){

        val result = main.validateCredentials(
            "",
            "1234",
            "12345"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `validate_password_empty_returns_false`(){
        val result = main.validateCredentials(
            "Faraz",
            "",
            "12345678"
        )

        assertThat(result).isFalse()
    }


    @Test
    fun validate_correct_username_password_returns_true(){
        val result = main.validateCredentials(
            "Faraz",
            "12345678",
            "12345678"
        )
        assertThat(result).isTrue()
    }



    @Test
    fun `validate_username_less_then_expected_returnsfalse`(){
        val result = main.validateCredentials(
            "Fa",
            "12345678",
            "12345678"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `validate_both_passwords_correct_returns_true`(){
        val result = main.validateCredentials(
            "Faraz",
            "12345678",
            "12345678"
        )
        assertThat(result).isTrue()

    }
}