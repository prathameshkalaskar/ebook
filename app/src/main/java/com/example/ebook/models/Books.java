package com.example.ebook.models;

public class Books {
    String Title,cover,content,type;

    public String getTitle() {
        return Title;
    }

    public String getCover() {
        return cover;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public Books(String title, String cover, String content, String type) {
        Title = title;
        this.cover = cover;
        this.content = content;
        this.type = type;
    }
}
