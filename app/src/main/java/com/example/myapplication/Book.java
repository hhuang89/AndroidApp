package com.example.myapplication;

public class Book {

    String bookCoverName, titleName, authorName;

    public String getAuthorName() {
        return authorName;
    }

    public String getBookCoverName() {
        return bookCoverName;
    }

    public String getTitleName() {
        return titleName;
    }

    public Book(String bookCoverName, String titleName, String authorName){
        this.authorName = authorName;
        this.bookCoverName = bookCoverName;
        this.titleName = titleName;
    }
}
