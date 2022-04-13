package com.itsfrz.basiccalci


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class ComputationLogicTest(){

    private val COMPUTATION_LOG = "COMPUTATIONLOG"
    private val computationLogic = ComputationLogic()


    /*

       When parameters are empty
        When addition check return value
        When subtraction check return value
        When division check return value
        When multiplication check return value

         theFunctionNameTest_testingWhetherItReturnsFalse_returnsTrue()
     */


    @Test
    fun equalTest_whenOperandsIsNotValid_returnZero(){
        val result = computationLogic.equal("","+","34")
        assertThat(result).isEqualTo(0.0)
    }

    @Test
    fun equalTest_whenInputOperatorIsAddition_checkOutput(){
        val result = computationLogic.equal("10","+","20")
        assertThat(result).isEqualTo(30.0)
    }

    @Test
    fun equalTest_whenInputOperatorIsSubtraction_checkOutput(){
        val result = computationLogic.equal("20","-","10")
//        Log.d(COMPUTATION_LOG, "equalTest_whenInputOperatorIsSubtraction_checkOutput: "+result)
        assertThat(result).isEqualTo(-10.0)
    }

    @Test
    fun equalTest_whenInputOperatorIsMultiplication_checkOutput(){
        val result = computationLogic.equal("10","*","20")
        assertThat(result).isEqualTo(200.0)
    }


    @Test
    fun equalTest_whenInputOperatorIsDivision_checkOutput(){
        val result = computationLogic.equal("10","/","20")
        assertThat(result).isEqualTo(2.0)
    }



}