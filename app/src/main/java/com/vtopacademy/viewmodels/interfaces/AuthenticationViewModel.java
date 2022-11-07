package com.vtopacademy.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.vtopacademy.states.AuthenticationCheckUiState;
import com.vtopacademy.states.AuthenticationUiState;

/** State holder interface for authentication screens. */
public interface AuthenticationViewModel {

    /** Returns AuthenticationUiState. */
    MutableLiveData<AuthenticationCheckUiState> getAuthenticationCheckUiState();

    /** Returns RegistrationEmailUiState. */
    MutableLiveData<AuthenticationUiState> getRegistrationEmailUiState();

    /** Returns RegistrationEmailVerificationUiState. */
    MutableLiveData<AuthenticationUiState> getRegistrationEmailVerificationUiState();

    /** Returns RegistrationDetailsUiState. */
    MutableLiveData<AuthenticationUiState> getRegistrationDetailsUiState();

    /** Returns RegistrationDetailsUiState. */
    MutableLiveData<AuthenticationUiState> getLoginAutomationUiState();

    /** Returns LoginUiState. */
    MutableLiveData<AuthenticationUiState> getLoginUiState();

    /** Returns ForgotPasswordEmailUiState. */
    MutableLiveData<AuthenticationUiState> getForgotPasswordEmailUiState();

    /** Returns ForgotPasswordEmailVerificationUiState. */
    MutableLiveData<AuthenticationUiState> getForgotPasswordEmailVerificationUiState();

    /** Returns ResetPasswordUiState. */
    MutableLiveData<AuthenticationUiState> getResetPasswordUiState();

    /** Returns ChangePasswordUiState. */
    MutableLiveData<AuthenticationUiState> getChangePasswordUiState();

    void generateRegistrationCode(String email);

    void verifyRegistrationCode(String code);

    void register(String password, String confirmPassword, String firstName, String lastName);

    void login(String email, String password);

    void login();

    void logout();

    void generateForgotPasswordCode(String email);

    void verifyForgotPasswordCode(String code);

    void resetPassword(String newPassword, String confirmNewPassword);

    void changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword);

}
