package com.edisonsanchez.appdesafiotecnicoindra.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edisonsanchez.appdesafiotecnicoindra.R;
import com.edisonsanchez.appdesafiotecnicoindra.model.ElementsListAdapter;
import com.edisonsanchez.appdesafiotecnicoindra.model.Elemento;

import java.util.List;



public class ElementsFragment extends Fragment {

    private MainActivityViewModel viewModel;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_elements, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity())
                .get(MainActivityViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerView);
        Observer<List<Elemento>> observer = this::inicializarRecyclerView;
        viewModel.elementos.observe(getViewLifecycleOwner(), observer);
        viewModel.getElements();
    }

    private void inicializarRecyclerView(List<Elemento> elementos) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ElementsListAdapter adapter = new ElementsListAdapter(requireContext(),elementos);
        recyclerView.setAdapter(adapter);
    }

}