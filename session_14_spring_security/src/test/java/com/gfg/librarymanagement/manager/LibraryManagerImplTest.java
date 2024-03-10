package com.gfg.librarymanagement.manager;

import com.gfg.librarymanagement.dto.FineDto;
import com.gfg.librarymanagement.dto.UserDto;
import com.gfg.librarymanagement.entity.FineAmount;
import com.gfg.librarymanagement.entity.User;
import com.gfg.librarymanagement.repo.BookRepository;
import com.gfg.librarymanagement.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(null);
        libraryManager.addUser(UserDto.builder().email("email").build());
        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));

    }

    @Test
    void borrowBook() {

    }

    @Test
    void returnBook() {
    }

    @Test
    void getFine() throws Exception {
        // Test 1 validate exception
        Mockito.when(userRepository.findByEmail(Mockito.any())).thenReturn(Optional.empty());
        assertThrows(Exception.class, ()-> libraryManager.getFine("email"));

        // Test 2 with actual user
        Double expectedFine = 10d;
        User userTestData = User.builder().fineAmount(FineAmount.builder().fine(expectedFine).build()).build();

        Mockito.when(userRepository.findByEmail(Mockito.any())).thenReturn(Optional.of(userTestData));
        FineDto actualFine = libraryManager.getFine("email");
        assertEquals(expectedFine,actualFine.getFine());
        assertTrue(expectedFine==actualFine.getFine());
        assertFalse(expectedFine!=actualFine.getFine());
        assertNotEquals(actualFine.getFine(), 5d);

    }

    @Test
    void payFine() {
    }
}