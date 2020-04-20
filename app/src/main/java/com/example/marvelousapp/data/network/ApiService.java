package com.example.marvelousapp.data.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.characters.response.CharactersResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @NonNull
    @GET("characters")
    Single<CharactersResponse> getCharacters(@Query("limit") int limit,
                                             @Nullable @Query("offset") Integer offset,
                                             @Nullable @Query("nameStartsWith") String name);

    @GET("characters/{id}")
    void getCharacter(@Path("id") int characterId);

}
