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
import com.vtopacademy.adapters.TopicAdapter;
import com.vtopacademy.databinding.FragmentTopicListBinding;
import com.vtopacademy.entities.Topic;
import com.vtopacademy.viewmodels.fakes.FakeMainViewModel;
import com.vtopacademy.viewmodels.interfaces.MainViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TopicListFragment extends Fragment {

    private FragmentTopicListBinding binding;
    private MainViewModel mainViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTopicListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(FakeMainViewModel.class);
        mainViewModel.getTopicListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingTopics()) {
                        binding.progressBar.setVisibility(View.VISIBLE);
                    }
                    else {
                        updateUI(result.getTopics());
                        binding.progressBar.setVisibility(View.GONE);
                    }
                }
        );
    }

    private void updateUI(List<Topic> topics) {
        TopicAdapter topicAdapter = new TopicAdapter(topics, this::onClick);
        binding.recyclerView.setAdapter(topicAdapter);
    }

    private void onClick(Topic topic) {
        mainViewModel.setSelectedTopic(topic);
        navigateToVideoListFragment();
    }

    private void navigateToVideoListFragment() {
        NavDirections action = TopicListFragmentDirections
                .actionTopicListFragmentToVideoListFragment();
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}