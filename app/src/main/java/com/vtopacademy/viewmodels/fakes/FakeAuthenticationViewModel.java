package com.vtopacademy.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.vtopacademy.states.AuthenticationCheckUiState;
import com.vtopacademy.states.AuthenticationUiState;
import com.vtopacademy.states.AuthenticationUiStatus;
import com.vtopacademy.viewmodels.interfaces.AuthenticationViewModel;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/** Fake MainViewModel implementation class. */
@HiltViewModel
public class FakeAuthenticationViewModel extends ViewModel implements AuthenticationViewModel {

    private String email;
    private String password;
    private String code;
    MutableLiveData<AuthenticationCheckUiState> authenticationCheckUiState = new MutableLiveData<>();
    MutableLiveData<AuthenticationUiState> registrationEmailUiState = new MutableLiveData<>();
    MutableLiveData<AuthenticationUiState> registrationEmailVerificationUiState
            = new MutableLiveData<>();
    MutableLiveData<AuthenticationUiState> registrationDetailsUiState = new MutableLiveData<>();
    MutableLiveData<AuthenticationUiState> loginAutomationUiState = new MutableLiveData<>();
    MutableLiveData<AuthenticationUiState> loginUiState = new MutableLiveData<>();
    MutableLiveData<AuthenticationUiState> forgotPasswordEmailUiState = new MutableLiveData<>();
    MutableLiveData<AuthenticationUiState> forgotPasswordEmailVerificationUiState
            = new MutableLiveData<>();
    MutableLiveData<AuthenticationUiState> resetPasswordUiState = new MutableLiveData<>();
    MutableLiveData<AuthenticationUiState> changePasswordUiState = new MutableLiveData<>();

    /** Constructs a new instance. */
    @Inject
    public FakeAuthenticationViewModel() {

    }

    @Override
    public MutableLiveData<AuthenticationCheckUiState> getAuthenticationCheckUiState() {
        authenticationCheckUiState.setValue(new AuthenticationCheckUiState(false, false));
        return authenticationCheckUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getRegistrationEmailUiState() {
        registrationEmailUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
        return registrationEmailUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getRegistrationEmailVerificationUiState() {
        registrationEmailVerificationUiState.setValue(
                new AuthenticationUiState(AuthenticationUiStatus.Idle));
        return registrationEmailVerificationUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getRegistrationDetailsUiState() {
        registrationDetailsUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
        return registrationDetailsUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getLoginAutomationUiState() {
        loginAutomationUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
        return loginAutomationUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getLoginUiState() {
        loginUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
        return loginUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getForgotPasswordEmailUiState() {
        forgotPasswordEmailUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
        return forgotPasswordEmailUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getForgotPasswordEmailVerificationUiState() {
        forgotPasswordEmailVerificationUiState.setValue(
                new AuthenticationUiState(AuthenticationUiStatus.Idle));
        return forgotPasswordEmailVerificationUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getResetPasswordUiState() {
        resetPasswordUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
        return resetPasswordUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getChangePasswordUiState() {
        changePasswordUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
        return changePasswordUiState;
    }

    @Override
    public void generateRegistrationCode(String email) {
        registrationEmailUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Success));
    }

    @Override
    public void verifyRegistrationCode(String code) {
        registrationEmailVerificationUiState.setValue(
                new AuthenticationUiState(AuthenticationUiStatus.Success));
        registrationEmailUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
    }

    @Override
    public void register(String password, String confirmPassword, String firstName, String lastName) {
        registrationDetailsUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Success));
        registrationEmailVerificationUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
    }

    @Override
    public void login(String email, String password) {
        loginUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Success));
        loginAutomationUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Success));
        registrationDetailsUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
        resetPasswordUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
        changePasswordUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
    }

    @Override
    public void login() {
        login(email, password);
    }

    @Override
    public void logout() {

    }

    @Override
    public void generateForgotPasswordCode(String email) {
        forgotPasswordEmailUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Success));
    }

    @Override
    public void verifyForgotPasswordCode(String code) {
        forgotPasswordEmailVerificationUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Success));
        forgotPasswordEmailUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
    }

    @Override
    public void resetPassword(String newPassword, String confirmNewPassword) {
        resetPasswordUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Success));
        forgotPasswordEmailVerificationUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle));
    }

    @Override
    public void changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword) {
        changePasswordUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Success));
    }
}