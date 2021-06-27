package com.mauriciolocatelli.bookstoremanager.repository;

import com.mauriciolocatelli.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
