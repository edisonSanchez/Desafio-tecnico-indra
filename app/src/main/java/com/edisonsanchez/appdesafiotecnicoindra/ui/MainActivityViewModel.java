package com.edisonsanchez.appdesafiotecnicoindra.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.edisonsanchez.appdesafiotecnicoindra.model.Constantes;
import com.edisonsanchez.appdesafiotecnicoindra.model.Elemento;
import com.edisonsanchez.appdesafiotecnicoindra.model.EndPointsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Elemento>> _elementos = new MutableLiveData<>();
    LiveData<List<Elemento>> elementos =_elementos;

    public void getElements() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EndPointsApi endPointsApi = retrofit.create(EndPointsApi.class);
        Call<List<Elemento>> request = endPointsApi.getPhotos();
        request.enqueue(new Callback<List<Elemento>>() {
            @Override
            public void onResponse(Call<List<Elemento>> call, Response<List<Elemento>> response) {
                List<Elemento> elementosResultantes = response.body();
                if(elementosResultantes != null){
                    List<Elemento> primerosElementos = new ArrayList<>();
                    for (int i= 0; i<15 ; i++){
                        primerosElementos.add(elementosResultantes.get(i));
                    }
                    _elementos.setValue(primerosElementos);
                }
            }

            @Override
            public void onFailure(Call<List<Elemento>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
