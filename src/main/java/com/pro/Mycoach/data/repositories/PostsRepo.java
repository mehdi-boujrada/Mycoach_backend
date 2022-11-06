package com.pro.Mycoach.data.repositories;

import com.pro.Mycoach.data.entities.Posts;
import org.yaml.snakeyaml.representer.BaseRepresenter;

public interface PostsRepo extends BaseRepository<Posts> {
    Posts findByTitle(String title);
}
