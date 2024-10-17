package cw.lms_ead.controllers;

import cw.lms_ead.Entities.Book;
import cw.lms_ead.Services.BookServices;
import cw.lms_ead.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("LMS/Books")
public class BookController {

    @Autowired
    private BookServices bookServices;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        try {
            return bookServices.getAllBooks();
        }catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @PostMapping
    public Map<String, Object> addBook(@RequestBody BookDTO bookDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            BookDTO addedBook = bookServices.addBook(bookDTO);

            response.put("message", "Book added complete");
            response.put("book", addedBook);

        }catch(Exception e) {
            System.out.println(e);
            response.put("message", "book not added");

        }
        return response;
    }

    @PutMapping("/{Id}")
    public Map<String, Object> updateBook(@PathVariable String Id, @RequestBody BookDTO bookDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
           BookDTO updatedBook = bookServices.updateBook(Id, bookDTO);
           response.put("message", "Book updated complete");
           response.put("book", updatedBook);
       }catch(Exception e) {
           System.out.println(e);
            response.put("message", "book not Updated");
       }
        return response;
    }

    @DeleteMapping("/{Id}")
    public String deleteBook(@PathVariable String Id) {
        try {
            bookServices.deleteBook(Id);
            return "Book deleted";
        }catch(Exception e) {
            System.out.println(e);
            return "Book not Deleted";
        }
    }

    @GetMapping("/{Id}")
    public BookDTO getBook(@PathVariable String Id) {
        try {
            return bookServices.getBook(Id);
        }catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
