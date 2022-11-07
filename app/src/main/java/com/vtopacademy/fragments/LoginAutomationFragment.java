package com.vtopacademy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.vtopacademy.databinding.FragmentLoginAutomationBinding;
import com.vtopacademy.states.AuthenticationUiState;
import com.vtopacademy.viewmodels.fakes.FakeAuthenticationViewModel;
import com.vtopacademy.viewmodels.interfaces.AuthenticationViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginAutomationFragment extends Fragment {

    private FragmentLoginAutomationBinding binding;
    private AuthenticationViewModel authenticationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginAutomationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authenticationViewModel = new ViewModelProvider(requireActivity()).get(
                FakeAuthenticationViewModel.class);
        authenticationViewModel.getLoginAutomationUiState().observe(
                getViewLifecycleOwner(), this::updateUI
        );
        authenticationViewModel.login();
    }

    private void updateUI(AuthenticationUiState result) {
        switch (result.getAuthenticationUiStatus()) {
            case InputError:
            case Failure:
                navigateToLoginFragment();
                break;
            case Success:
                navigateToCategoryListFragment();
                break;
        }
    }

    private void navigateToCategoryListFragment() {
        NavDirections action = LoginAutomationFragmentDirections
                .actionLoginAutomationFragmentToCategoryListFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    private void navigateToLoginFragment() {
        NavDirections action = LoginAutomationFragmentDirections
                .actionLoginAutomationFragmentToLoginFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}