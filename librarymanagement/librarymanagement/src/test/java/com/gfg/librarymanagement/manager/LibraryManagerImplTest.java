package com.gfg.librarymanagement.manager;

import com.gfg.librarymanagement.dto.UserDto;
import com.gfg.librarymanagement.repo.BookRepository;
import com.gfg.librarymanagement.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LibraryManagerImplTest {
    @Mock
    UserRepository userRepository;

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    LibraryManagerImpl libraryManager;

    @Test
    void getBook() {

    }

    @Test
    void addBook() {
    }

    @Test
    void addUser() {
        Mockito.doNothing().when(userRepository.save(Mockito.any()));
        libraryManager.addUser(UserDto.builder().email("email").build());
    }

    @Test
    void borrowBook() {
    }

    @Test
    void returnBook() {
    }

    @Test
    void getFine() {
    }

    @Test
    void payFine() {
    }
}