package com.gfg.librarymanagement.repo;

import com.gfg.librarymanagement.entity._Fine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FineCache extends CrudRepository<_Fine,String> {
    Optional<_Fine> findByEmail(String fine);
}
