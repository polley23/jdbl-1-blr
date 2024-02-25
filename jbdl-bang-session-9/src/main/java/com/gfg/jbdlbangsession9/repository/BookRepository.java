package com.gfg.jbdlbangsession9.repository;

import com.gfg.jbdlbangsession9.dao.Author;
import com.gfg.jbdlbangsession9.dao.Book;
import com.gfg.jbdlbangsession9.dao.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAllByBname(String bname);

    @Query("SELECT b FROM Book b JOIN b.genre g WHERE g.gname = :genreName")
    List<Book> findBooksByGenreName(@Param("genreName") String genreName);

    @Query("SELECT b FROM Book b JOIN b.author a WHERE a.authorName = :authorName")
    Page<Book> findBooksByAuthorName(@Param("authorName") String authorName, Pageable pageable);

    @Query("SELECT b FROM Book b JOIN b.bookVolumes bv WHERE bv.bookVersion = :bookVolume")
    List<Book> findBooksByBookVolume(@Param("bookVolume") String bookVolume);

    Optional<Book> findByBnameAndPublisherName(String bname, String publisherName);

    @Query("SELECT b FROM Book b JOIN b.author a WHERE a.authorName = :authorName and b.genre.gname = :genre")
    List<Book> findBooksByAuthorNameAndGenre(@Param("authorName") String authorName,@Param("genre")String Genre);
}
