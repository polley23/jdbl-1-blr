package com.gfg.librarymanagement.controllers;


import com.gfg.librarymanagement.dto.BookDto;
import com.gfg.librarymanagement.dto.BorrowRequest;
import com.gfg.librarymanagement.dto.FineDto;
import com.gfg.librarymanagement.dto.UserDto;
import com.gfg.librarymanagement.manager.LibraryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Api {

   @Autowired
    LibraryManager libraryManager;

    @GetMapping("/home")
    ResponseEntity<String> home(){
       return ResponseEntity.ok("Welcome to library");
    }

    @GetMapping("/api/admin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    ResponseEntity<String> admin(){
        return ResponseEntity.ok("Welcome to Admin page");
    }

    @GetMapping("/api/book")
    @PreAuthorize("hasAnyRole('ADMIN','LIBRARIAN','USER', 'GUEST')")
    ResponseEntity<BookDto> getBooks(@RequestParam("name") Optional<String> name ){
        if (name.orElse("").isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(libraryManager.getBook(name.get()));
    }

    @PostMapping("/api/book")
    @PreAuthorize("hasAnyRole('ADMIN','LIBRARIAN')")
    ResponseEntity addBooks(@RequestBody BookDto bookDto){
        if (bookDto == null){
            return ResponseEntity.badRequest().build();
        }
        libraryManager.addBook(bookDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/user")
    @PreAuthorize("hasAnyRole('ADMIN','LIBRARIAN')")
    ResponseEntity addUser(@RequestBody UserDto userDto){
        if (userDto == null){
            return ResponseEntity.badRequest().build();
        }
        try {
            libraryManager.addUser(userDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/book/order")
    @PreAuthorize("hasAnyRole('ADMIN','USER','LIBRARIAN')")
    ResponseEntity borrowBooks(@RequestBody BorrowRequest borrowRequest){
        if (borrowRequest == null){
            return ResponseEntity.badRequest().build();
        }
        try {
            libraryManager.borrowBook(borrowRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/book/order")
    @PreAuthorize("hasAnyRole('ADMIN','USER','LIBRARIAN')")
    ResponseEntity returnBook(@RequestBody BorrowRequest borrowRequest){
        if (borrowRequest == null){
            return ResponseEntity.badRequest().build();
        }
        try {
            libraryManager.returnBook(borrowRequest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/user/{email}/fine_amount")
    @PreAuthorize("hasAnyRole('ADMIN','USER','LIBRARIAN')")
    ResponseEntity getFine(@PathVariable("email") String email){
        if (email.isEmpty()){
            return ResponseEntity.ok().build();
        }
        try {
            return ResponseEntity.ok(libraryManager.getFine(email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/api/user/{user_id}/fine_amount")
    @PreAuthorize("hasAnyRole('ADMIN','USER','LIBRARIAN')")
    ResponseEntity payFine(@PathVariable("user_id") String userId, @RequestBody FineDto fineDto){
        if (userId.isEmpty() || fineDto == null){
            return ResponseEntity.ok().build();
        }
        try {
            libraryManager.payFine(userId, fineDto.getFine());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

}
