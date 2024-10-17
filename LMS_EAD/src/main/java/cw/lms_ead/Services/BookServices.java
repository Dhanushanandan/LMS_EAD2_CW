package cw.lms_ead.Services;


import cw.lms_ead.Entities.Book;
import cw.lms_ead.dto.BookDTO;
import cw.lms_ead.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;

    //insert a book
    public BookDTO addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        bookRepository.save(book);
        return bookDTO;
    }



    //selecting all books
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
        for (Book book : books) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthor(book.getAuthor());
            bookDTOs.add(bookDTO);

        }
        return bookDTOs;
    }

    //update a book
    public BookDTO updateBook(String Id,BookDTO bookDTO) {
        Book book = bookRepository.findById(Id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"BooK Not Found"));
        book.setId(bookDTO.getId());
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        bookRepository.save(book);
        return bookDTO;
    }

    //delete a book
    public void deleteBook(String Id) {
        if(!bookRepository.existsById(Id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"BooK Not Found");
        }
        bookRepository.deleteById(Id);
    }

    //get a single book using id
    public BookDTO getBook(String Id) {
        Book book = bookRepository.findById(Id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"BooK Not Found"));
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        return bookDTO;
    }
}
