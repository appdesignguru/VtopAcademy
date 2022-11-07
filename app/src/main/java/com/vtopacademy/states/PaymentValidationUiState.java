package com.vtopacademy.states;

public class PaymentValidationUiState {

    private final boolean fetchingUiState;
    private final boolean activePayment;

    public PaymentValidationUiState(boolean fetchingUiState, boolean activePayment) {
        this.fetchingUiState = fetchingUiState;
        this.activePayment = activePayment;
    }

    public boolean isFetchingUiState() {
        return fetchingUiState;
    }

    public boolean hasActivePayment() {
        return activePayment;
    }
}