package com.itsfrz.authentication

import com.itsfrz.authentication.model.Contact

interface AuthenticationCommunicator {

    fun routeToLogin(username : String);
    fun routeToSignUp();
    fun routeFromLoginToLandingPage(username: String);
    fun routerFromLoginToContactPage(username : String);
    fun routeFromContactToLandingPage();
    fun routerFromLandingToContactPage();
    fun routeFromContactToAddContact();
    fun routeFromContactToContactDetail(contact : Contact)
}