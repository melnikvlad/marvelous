package com.example.marvelousapp.data;

import androidx.annotation.Nullable;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("characters")
    public void getCharacters(@Query("limit") int limit,
                              @Nullable @Query("offset") Integer offset,
                              @Nullable @Query("nameStartsWith") String name);

    @GET("characters/{id}")
    public void getCharacter(@Path("id") int characterId);

}
