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
import androidx.recyclerview.widget.LinearLayoutManager;
import com.vtopacademy.adapters.SubjectAdapter;
import com.vtopacademy.databinding.FragmentSubjectListBinding;
import com.vtopacademy.entities.Subject;
import com.vtopacademy.viewmodels.fakes.FakeMainViewModel;
import com.vtopacademy.viewmodels.interfaces.MainViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SubjectListFragment extends Fragment {

    private FragmentSubjectListBinding binding;
    private MainViewModel mainViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSubjectListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(FakeMainViewModel.class);
        mainViewModel.getSubjectListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingSubjects()) {
                        binding.progressBar.setVisibility(View.VISIBLE);
                    }
                    else {
                        updateUI(result.getSubjects());
                        binding.progressBar.setVisibility(View.GONE);
                    }
                }
        );
    }

    private void updateUI(List<Subject> subjects) {
        SubjectAdapter subjectAdapter = new SubjectAdapter(subjects, this::onClick);
        binding.recyclerView.setAdapter(subjectAdapter);
    }

    private void onClick(Subject subject) {
        mainViewModel.setSelectedSubject(subject);
        if (subject.requiresPayment()) {

        }
        else {
            navigateToTopicListFragment();
        }
    }

    private void navigateToTopicListFragment() {
        NavDirections action = SubjectListFragmentDirections
                .actionSubjectListFragmentToTopicListFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}