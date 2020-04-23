package com.example.marvelousapp.data.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.characters.response.CharactersResponse;
import com.example.marvelousapp.data.models.comics.response.ComicsResponse;
import com.example.marvelousapp.data.models.stories.StoriesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    //-------------------------------- CHARACTERS --------------------------------

    @NonNull
    @GET("characters")
    Observable<CharactersResponse> getCharacters(@Query("limit") int limit,
                                                 @Nullable @Query("offset") Integer offset,
                                                 @Nullable @Query("nameStartsWith") String name);

    @GET("characters/{id}")
    void getCharacter(@Path("id") int characterId);

    @GET("characters/{id}/comics")
    void getCharacterComics(@Path("id") int characterId);

    @GET("characters/{id}/stories")
    void getCharacterStories(@Path("id") int characterId);

    //-------------------------------- CHARACTER --------------------------------

    @GET("comics")
    Observable<ComicsResponse> getComics();

    @GET("comics/{id}")
    void getComics(@Path("id") int comicsId);

    @GET("comics/{id}/characters")
    void getComicsCharacters(@Path("id") int comicsId);

    //-------------------------------- STORIES --------------------------------

    @GET("stories")
    Observable<StoriesResponse> getStories();

    @GET("stories/{id}")
    void getStories(@Path("id") int striesId);

    //-------------------------------- SERIES --------------------------------

    @GET("series")
    Observable<ComicsResponse> getSeries();

    @GET("series/{id}")
    void getSeries(@Path("id") int seriesId);

    //-------------------------------- EVENTS --------------------------------

    @GET("events")
    Observable<ComicsResponse> getEvents();

    @GET("events/{id}")
    void getEvents(@Path("id") int eventsId);
}
