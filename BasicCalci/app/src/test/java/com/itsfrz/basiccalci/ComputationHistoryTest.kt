package com.itsfrz.basiccalci

import com.google.common.truth.Truth.assertThat

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*


@RunWith(JUnit4::class)
class ComputationHistoryTest{

    val computationHistory = ComputationHistory()


    /*
           data should not be empty
           history should not contains letters in it
           data should be save in an history stack

     */

    @Test
    fun saveHistoryTest_whenDataIsEmpty_returnsFalse()
    {
        val result = computationHistory.saveHistory("",Stack<String>());
        assertThat(result).isFalse()
    }

    @Test
    fun saveHistory_whenDataContainsLetter_returnFalse(){
        val result = computationHistory.saveHistory("12+abs",Stack<String>());
        assertThat(result).isFalse()
    }


    @Test
    fun saveHistory_whenHistoryIsPersist_returnTrue(){
        val myHistory = Stack<String>()
        val result = computationHistory.saveHistory("12+12",myHistory);
        assertThat(myHistory.size > 0).isTrue()
    }

    /*

     History should pop elements in order to showcase previous results
     Stack(History) should not pop element from empty stack

  */

    @Test
    fun showHistory_whenHistoryIsRetrieving_returnTrue(){
        val myHistory = Stack<String>()
        myHistory.push("12+12=24")
        val result = computationHistory.showHistory(myHistory)
        assertThat(result.equals("12+12=24")).isTrue()
    }

    @Test
    fun showHistory_whenHistoryIsNotPresent_returnEmpty(){
        val myHistory = Stack<String>()
        val result = computationHistory.showHistory(myHistory)
        assertThat(result).isEmpty()
    }

}