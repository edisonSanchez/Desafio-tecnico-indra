package com.edisonsanchez.appdesafiotecnicoindra.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;


import com.edisonsanchez.appdesafiotecnicoindra.R;

public class MainActivity extends AppCompatActivity {
    private ElementsFragment fragment = new ElementsFragment();
    private MainActivityViewModel viewModel;
    private Toolbar appBar;
    private Button refrescar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        appBar = findViewById(R.id.app_bar);
        refrescar = appBar.findViewById(R.id.boton_refrescar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        setSupportActionBar(appBar);
        getSupportFragmentManager().beginTransaction().add(
                R.id.fragmentContainer, fragment).commitNow();
        getSupportFragmentManager().beginTransaction().show(fragment).commitNow();
        refrescar.setOnClickListener(v -> viewModel.getElements());
    }


}