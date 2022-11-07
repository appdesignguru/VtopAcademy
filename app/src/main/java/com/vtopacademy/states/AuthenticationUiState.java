package com.vtopacademy.states;

public class AuthenticationUiState {

    private final AuthenticationUiStatus authenticationUiStatus;
    private final String errorMessage;

    public AuthenticationUiState(AuthenticationUiStatus authenticationUiStatus, String errorMessage) {
        this.authenticationUiStatus = authenticationUiStatus;
        this.errorMessage = errorMessage;
    }

    public AuthenticationUiState(AuthenticationUiStatus authenticationUiStatus) {
        this.authenticationUiStatus = authenticationUiStatus;
        errorMessage = "";
    }

    public AuthenticationUiStatus getAuthenticationUiStatus() {
        return authenticationUiStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}