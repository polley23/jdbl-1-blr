package com.gfg.jbdlbangsession9.manager;

import com.gfg.jbdlbangsession9.dao.Book;
import com.gfg.jbdlbangsession9.dao.Genre;
import com.gfg.jbdlbangsession9.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class BookManager {

    @Autowired
    BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }

    public Book get(Long  id){
        return bookRepository.findById(id).get();
    }

    public Book get(String  name){
        return bookRepository.findAllByBname(name).get(0);
    }

    public Book getBookByGenre(String  genreName){
        return bookRepository.findBooksByGenreName(genreName).get(0);
    }

    public List<Book> getBookByAuthorName(String  authorName, int limit, int offset){
        PageRequest p = PageRequest.of(offset,limit, Sort.by("id"));
        return bookRepository.findBooksByAuthorName(authorName, p).getContent();
    }

    public Book getBookByBookVolume(String  bookVolume){
        return bookRepository.findBooksByBookVolume(bookVolume).get(0);
    }

    public Book getBookByBnamePublisherName(String bname, String publisherName){
        return bookRepository.findByBnameAndPublisherName(bname, publisherName).get();
    }

    public Book getBookByAuthorAndGenre(String author, String genre){
        return bookRepository.findBooksByAuthorNameAndGenre(author, genre).get(0);
    }
}
