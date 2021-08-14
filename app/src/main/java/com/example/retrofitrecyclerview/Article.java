package com.example.retrofitrecyclerview;

import java.util.List;

public class Article {

    public String title;
    public String slug;
    public String body;
    public String createdAt;
    public String updatedAt;
    public List<String> tagList = null;
    public String description;
    public Author author;
    public Boolean favorited;
    public Integer favoritesCount;

}
