package com.example.admin.scloud.data.source.local;

import com.example.admin.s_cloud.R;
import com.example.admin.scloud.data.model.Genre;
import com.example.admin.scloud.data.source.GenresDataSource;
import com.example.admin.scloud.utils.GenreEntity;

import java.util.ArrayList;
import java.util.List;

public class GenresLocalDataSource implements GenresDataSource {
    @Override
    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();
        genres = new ArrayList<Genre>();
        genres.add(new Genre(GenreEntity.ALL_AUDIO,
                R.string.all_audio, R.drawable.audio_genre));
        genres.add(new Genre(GenreEntity.CLASSICAL,
                R.string.classic, R.drawable.classic_genre));
        genres.add(new Genre(GenreEntity.ALTERNATIVE,
                R.string.alternative, R.drawable.alternative_genre));
        genres.add(new Genre(GenreEntity.COUNTRY,
                R.string.country, R.drawable.country_genre));
        genres.add(new Genre(GenreEntity.AMBIENT,
                R.string.ambient, R.drawable.ambient_genre));
        return genres;
    }
}
