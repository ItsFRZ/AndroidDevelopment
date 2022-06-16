package com.itsfrz.authentication

interface AuthenticationCommunicator {

    fun routeToLogin(username : String);
    fun routeToSignUp();
    fun routeFromLoginToLandingPage(username: String);
    fun routerFromLoginToContactPage(username : String);
    fun routeFromContactToLandingPage();
    fun routerFromLandingToContactPage();
    fun routeFromContactToAddContact();
}