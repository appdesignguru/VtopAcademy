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
import com.vtopacademy.databinding.FragmentRegistrationEmailVerificationBinding;
import com.vtopacademy.states.AuthenticationUiState;
import com.vtopacademy.viewmodels.fakes.FakeAuthenticationViewModel;
import com.vtopacademy.viewmodels.interfaces.AuthenticationViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RegistrationEmailVerificationFragment extends Fragment {

    private FragmentRegistrationEmailVerificationBinding binding;
    private AuthenticationViewModel authenticationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegistrationEmailVerificationBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.submitButton.setOnClickListener(buttonView -> {
            authenticationViewModel.verifyRegistrationCode(binding.codeEditText.getText().toString());
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authenticationViewModel = new ViewModelProvider(requireActivity()).get(
                FakeAuthenticationViewModel.class);
        authenticationViewModel.getRegistrationEmailVerificationUiState().observe(
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
                navigateToRegistrationDetailsFragment();
                break;
        }
    }

    private void navigateToRegistrationDetailsFragment() {
        NavDirections action = RegistrationEmailVerificationFragmentDirections
                .actionRegistrationEmailVerificationFragmentToRegistrationDetailsFragment();
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