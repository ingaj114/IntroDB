package com.company.objects;

public class Authors {
    private int bookid;
    private String name;
    private int age;

    public Authors(int bookid, String name, int age) {
        this.bookid = bookid;
        this.name = name;
        this.age = age;
    }

    public Authors() {
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = this.bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
