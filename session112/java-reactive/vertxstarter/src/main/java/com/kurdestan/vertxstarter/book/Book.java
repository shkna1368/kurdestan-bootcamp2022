package com.kurdestan.vertxstarter.book;

import java.util.List;

public class Book {

  private int id;
  private String title;

  public Book() {
  }

  public Book(int id, String title) {
    this.id = id;
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public static List<Book> findAll(){
    Book b1=new Book(1,"java code geeks");
    Book b2=new Book(2,"Ka");
       return List.of(b1,b2);

  }

}
