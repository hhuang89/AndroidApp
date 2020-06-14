package com.example.myapplication;

import java.io.Serializable;

public class Book implements Serializable {

    String bookCoverName, titleName, authorName, content, image2, image3;
    int count;

    public int getCount(){ return count; }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getBookCoverName() {
        return bookCoverName;
    }

    public String getTitleName() {
        return titleName;
    }
    public String getContent() {
        return content;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public Book(String bookCoverName, String titleName, String authorName, String content, String image2, String image3, int count){
        this.authorName = authorName;
        this.bookCoverName = bookCoverName;
        this.titleName = titleName;
        this.content = content;
        this.image2 = image2;
        this.image3 = image3;
        this.count = count;
    }

}
