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
import com.vtopacademy.adapters.CategoryAdapter;
import com.vtopacademy.databinding.FragmentCategoryListBinding;
import com.vtopacademy.entities.Category;
import com.vtopacademy.viewmodels.fakes.FakeMainViewModel;
import com.vtopacademy.viewmodels.interfaces.MainViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CategoryListFragment extends Fragment {

    private FragmentCategoryListBinding binding;
    private MainViewModel mainViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCategoryListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(FakeMainViewModel.class);
        mainViewModel.getCategoryListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingCategories()) {
                        binding.progressBar.setVisibility(View.VISIBLE);
                    }
                    else {
                        updateUI(result.getCategories());
                        binding.progressBar.setVisibility(View.GONE);
                    }
                }
        );
    }

    private void updateUI(List<Category> categories) {
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories, this::onClick);
        binding.recyclerView.setAdapter(categoryAdapter);
    }

    private void onClick(Category category) {
        mainViewModel.setSelectedCategory(category);
        navigateToSubjectListFragment();
    }

    private void navigateToSubjectListFragment() {
        NavDirections action = CategoryListFragmentDirections
                .actionCategoryListFragmentToSubjectListFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}