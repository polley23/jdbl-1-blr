package com.gfg.librarymanagement.controllers;


import com.gfg.librarymanagement.dto.BookDto;
import com.gfg.librarymanagement.dto.BorrowRequest;
import com.gfg.librarymanagement.dto.FineDto;
import com.gfg.librarymanagement.dto.UserDto;
import com.gfg.librarymanagement.manager.LibraryManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RestController
public class Api {

   // @Autowired
    LibraryManager libraryManager;

    @GetMapping("/api/book")
    ResponseEntity<BookDto> getBooks(@RequestParam("name") Optional<String> name ){
        if (name.orElse("").isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(libraryManager.getBook(name.get()));
    }

    @PostMapping("/api/book")
    ResponseEntity addBooks(@RequestBody BookDto bookDto){
        if (bookDto == null){
            return ResponseEntity.badRequest().build();
        }
        libraryManager.addBook(bookDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/user")
    ResponseEntity addUser(@RequestBody UserDto userDto){
        if (userDto == null){
            return ResponseEntity.badRequest().build();
        }
        libraryManager.addUser(userDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/book/order")
    ResponseEntity borrowBooks(@RequestBody BorrowRequest borrowRequest){
        if (borrowRequest == null){
            return ResponseEntity.badRequest().build();
        }
        libraryManager.borrowBook(borrowRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/book/order")
    ResponseEntity returnBook(@RequestBody BorrowRequest borrowRequest){
        if (borrowRequest == null){
            return ResponseEntity.badRequest().build();
        }
        libraryManager.returnBook(borrowRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/user/{email}/fine_amount")
    ResponseEntity<FineDto> getFine(@PathVariable("email") String email){
        if (email.isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(libraryManager.getFine(email));
    }


    @PutMapping("/api/user/{user_id}/fine_amount")
    ResponseEntity payFine(@PathVariable("user_id") String userId, @RequestBody FineDto fineDto){
        if (userId.isEmpty() || fineDto == null){
            return ResponseEntity.ok().build();
        }
        libraryManager.payFine(userId, fineDto.getFine());
        return ResponseEntity.ok().build();
    }

}
