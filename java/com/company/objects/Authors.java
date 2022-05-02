package com.company.objects;

public class Authors {
    private int id;
    private int bookId;
    private String name;
    private int age;

    public Authors(int id, int bookId, String name, int age) {
        this.id = id;
        this.bookId = bookId;
        this.name = name;
        this.age = age;
    }
    public Authors() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookd) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
