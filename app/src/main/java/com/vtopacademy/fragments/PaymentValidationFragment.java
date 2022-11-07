package com.vtopacademy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.vtopacademy.databinding.FragmentPaymentValidationBinding;
import com.vtopacademy.viewmodels.fakes.FakeMainViewModel;
import com.vtopacademy.viewmodels.interfaces.MainViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PaymentValidationFragment extends Fragment {

    private FragmentPaymentValidationBinding binding;
    private MainViewModel mainViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPaymentValidationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(FakeMainViewModel.class);
        mainViewModel.getPaymentValidationUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingUiState()) {

                    }
                    else {
                        navigate(result.hasActivePayment());
                    }
                }
        );
    }

    private void navigate(boolean hasActivePayment) {
        if (hasActivePayment) {

        }
        else {

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}