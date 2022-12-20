package com.example.examenavimar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.examenavimar.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    private static final String TAG = "MainActivity";
    private FragmentSecondBinding binding;
    private PersistenciaPlats persistenciaPlats;
    private List<TextView> textViewsPlats;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewsPlats = new ArrayList<>();
        textViewsPlats.add((TextView) view.findViewById(R.id.text_view_plat_1));
        textViewsPlats.add((TextView) view.findViewById(R.id.text_view_plat_2));
        textViewsPlats.add((TextView) view.findViewById(R.id.text_view_plat_3));

        persistenciaPlats = new PersistenciaPlats();
        List<String> nomsPlats = persistenciaPlats.obtenirNomsPlats();

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}