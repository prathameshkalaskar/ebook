package com.example.ebook.models;

public class TextBook {

    String chapterName, chapter;

    public TextBook(String chapterName, String chapter) {
        this.chapterName = chapterName;
        this.chapter = chapter;
    }

    public String getChapterName() {
        return chapterName;
    }

    public String getChapter() {
        return chapter;
    }
}
