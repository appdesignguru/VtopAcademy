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
import com.vtopacademy.databinding.FragmentAuthenticationCheckBinding;
import com.vtopacademy.viewmodels.fakes.FakeAuthenticationViewModel;
import com.vtopacademy.viewmodels.interfaces.AuthenticationViewModel;
import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class AuthenticationCheckFragment extends Fragment {

    private FragmentAuthenticationCheckBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAuthenticationCheckBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AuthenticationViewModel authenticationViewModel = new ViewModelProvider(
                requireActivity()).get(FakeAuthenticationViewModel.class);
        authenticationViewModel.getAuthenticationCheckUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isProcessing()) {
                        doNothing();
                    }
                    else if (result.hasActiveLoggedInUser()){
                        navigateToCategoryListFragment();
                    }
                    else {
                        navigateToRegistrationEmailFragment();
                    }
                }
        );
    }

    private void doNothing() {

    }

    private void navigateToRegistrationEmailFragment() {
        NavDirections action = AuthenticationCheckFragmentDirections
                .actionAuthenticationCheckFragmentToRegistrationEmailFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    private void navigateToCategoryListFragment() {
        NavDirections action = AuthenticationCheckFragmentDirections
                .actionAuthenticationCheckFragmentToCategoryListFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}