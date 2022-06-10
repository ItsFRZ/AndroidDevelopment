package com.itsfrz.authentication

interface AuthenticationCommunicator {

    fun routeToLogin(username : String);
    fun routeToSignUp();
    fun routeFromLoginToLandingPage(username: String);
}