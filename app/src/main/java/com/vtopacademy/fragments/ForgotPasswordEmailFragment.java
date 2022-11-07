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
import com.vtopacademy.databinding.FragmentForgotPasswordEmailBinding;
import com.vtopacademy.states.AuthenticationUiState;
import com.vtopacademy.viewmodels.fakes.FakeAuthenticationViewModel;
import com.vtopacademy.viewmodels.interfaces.AuthenticationViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ForgotPasswordEmailFragment extends Fragment {

    private FragmentForgotPasswordEmailBinding binding;
    private AuthenticationViewModel authenticationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentForgotPasswordEmailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.submitButton.setOnClickListener(buttonView -> {
            authenticationViewModel.generateForgotPasswordCode(binding.emailEditText.getText().toString());
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authenticationViewModel = new ViewModelProvider(requireActivity()).get(
                FakeAuthenticationViewModel.class);
        authenticationViewModel.getForgotPasswordEmailUiState().observe(
                getViewLifecycleOwner(), this::updateUI
        );
    }

    private void updateUI(AuthenticationUiState result) {
        switch (result.getAuthenticationUiStatus()) {
            case Idle:
                hideLoadingUi();
                break;
            case Processing:
                showLoadingUi();
                break;
            case InputError:
            case Failure:
                binding.errorTextView.setText(result.getErrorMessage());
                hideLoadingUi();
                break;
            case Success:
                hideLoadingUi();
                navigateToForgotPasswordEmailVerificationFragment();
                break;
        }
    }

    private void navigateToForgotPasswordEmailVerificationFragment() {
        NavDirections action = ForgotPasswordEmailFragmentDirections
                .actionForgotPasswordEmailFragmentToForgotPasswordEmailVerificationFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);

    }

    private void showLoadingUi() {
        binding.progressBar.setVisibility(View.GONE);
        binding.submitButton.setEnabled(true);
    }

    private void hideLoadingUi() {
        binding.progressBar.setVisibility(View.GONE);
        binding.submitButton.setEnabled(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}