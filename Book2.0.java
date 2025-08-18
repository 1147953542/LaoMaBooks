package com.msb.test14;

import java.io.Serializable;

public class Book implements Serializable {
    //属性：

    //书籍编号
    private int No;
    //书籍名字
    private String  Name;
    //书籍作者
    private String Author;


    //set and get:

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    //构造器：
    public Book() {
    }


    public Book(int No, String Name, String Author) {
        this.No = No;
        this.Name = Name;
        this.Author = Author;
    }
}
