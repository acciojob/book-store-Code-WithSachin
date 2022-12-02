package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody (required = true) Book book){
        bookService.createBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book>getBookById(@PathVariable String id){
        return new ResponseEntity<>(bookService.findBookById(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/books/get-all-books")
    public ResponseEntity<List<Book>>GetAllBooks(){
        return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/books/get-books-by-author")
    public ResponseEntity<List<Book>>getBooksByAutor(@RequestParam String author){
        return new ResponseEntity<>(bookService.findBooksByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre){
        return new ResponseEntity(bookService.findBooksByGenre(genre),HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        bookService.deleteBookById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deletealbooks() {
        bookService.deleteAllBooks();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
