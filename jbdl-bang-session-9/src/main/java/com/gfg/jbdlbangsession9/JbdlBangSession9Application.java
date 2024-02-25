package com.gfg.jbdlbangsession9;

import com.gfg.jbdlbangsession9.dao.Author;
import com.gfg.jbdlbangsession9.dao.Book;
import com.gfg.jbdlbangsession9.dao.BookVolume;
import com.gfg.jbdlbangsession9.dao.Genre;
import com.gfg.jbdlbangsession9.manager.BookManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class JbdlBangSession9Application {

	public static void main(String[] args) {

		WebApplicationContext ioc = (WebApplicationContext)SpringApplication.run(JbdlBangSession9Application.class, args);

		BookManager bookManager = ioc.getBean(BookManager.class);

		Genre genre = Genre.builder().gname("Comic")
				.build();

		Author author1 = Author.builder().authorName("author1")
				.build();
		Author author2 = Author.builder().authorName("author2")
				.build();
		BookVolume volume = BookVolume.builder().bookVersion("v1").build();

		Book book = Book.builder()
				.bname("book")
				.genre(genre)
				.author(Arrays.asList(author1, author2))
				.publisherName("pub1")
				.bookVolumes(Arrays.asList(volume))
				.build();
		volume.setBook(book);
		bookManager.save(book);


//		Book book2 = bookManager.get("book");
//		log.info(book2.getAuthor().get(0).getAuthorName());

//		// Get book by a specific genre
//		List<Book> books = bookManager.getBookByAuthorName("author1", 1, 0);
//
//		for (Book b : books){
//			log.info(b.getBname());
//		}
//
//		Book book3 = bookManager.getBookByBnamePublisherName("book","pub1");
//		log.info(book3.getBname());

		Book book3 = bookManager.getBookByAuthorAndGenre("author1","comic");
		log.info(book3.getBname());
	}

}
