package com.edisonsanchez.appdesafiotecnicoindra.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPointsApi {

    @GET(Constantes.GET_PHOTOS)
    Call<List<Elemento>> getPhotos();

}
