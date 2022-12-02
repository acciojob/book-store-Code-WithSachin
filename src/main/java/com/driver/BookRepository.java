package com.driver;
import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class BookRepository {

    HashMap<Integer, Book> bookDataBase=new HashMap<>();

    public BookRepository(){

    }

    public Book save(Book book){
        int id=bookDataBase.size()+1;
        book.setId(id);
        bookDataBase.put(id, book);
        return book;
    }

    public Book findBookById(int id){
        return bookDataBase.get(id);
    }

    public List<Book> findAll(){
        List<Book> listOfBooks=new ArrayList<>();
        for(Book book:bookDataBase.values()){
            listOfBooks.add(book);
        }
        return listOfBooks;
    }

    public void deleteBookById(int id){
        bookDataBase.remove(id);
        return;
    }

    public void deleteAll(){
        bookDataBase.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> booksByAuthorName=new ArrayList<>();
        for(Book book:bookDataBase.values()){
            if(book.getAuthor().equals(author)){
                booksByAuthorName.add(book);
            }
        }
        return booksByAuthorName;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> booksByGenre=new ArrayList<>();
        for(Book book:bookDataBase.values()){
            if(book.getGenre().equals(genre)){
                booksByGenre.add(book);
            }
        }
        return booksByGenre;
    }
}
