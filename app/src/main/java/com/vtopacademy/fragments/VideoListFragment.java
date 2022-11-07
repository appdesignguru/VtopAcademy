package com.vtopacademy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.vtopacademy.adapters.VideoAdapter;
import com.vtopacademy.databinding.FragmentVideoListBinding;
import com.vtopacademy.entities.Video;
import com.vtopacademy.viewmodels.fakes.FakeMainViewModel;
import com.vtopacademy.viewmodels.interfaces.MainViewModel;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class VideoListFragment extends Fragment {

    private FragmentVideoListBinding binding;
    private MainViewModel mainViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentVideoListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(requireActivity()).get(FakeMainViewModel.class);
        mainViewModel.getVideoListUiState().observe(
                getViewLifecycleOwner(), result -> {
                    if (result.isFetchingVideos()) {
                        binding.progressBar.setVisibility(View.VISIBLE);
                    }
                    else {
                        updateUI(result.getVideos());
                        binding.progressBar.setVisibility(View.GONE);
                    }
                }
        );
    }

    private void updateUI(List<Video> videos) {
        VideoAdapter videoAdapter = new VideoAdapter(videos, this::onClick);
        binding.recyclerView.setAdapter(videoAdapter);
    }

    private void onClick(Video video) {
        mainViewModel.setSelectedVideo(video);
        //navigate
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
