package com.vtopacademy.states;

public class AuthenticationCheckUiState {

    private final boolean processing;
    private final boolean  activeLoggedInUser;

    public AuthenticationCheckUiState(boolean processing, boolean activeLoggedInUser) {
        this.processing = processing;
        this.activeLoggedInUser = activeLoggedInUser;
    }

    public boolean isProcessing() {
        return processing;
    }

    public boolean hasActiveLoggedInUser() {
        return activeLoggedInUser;
    }
}