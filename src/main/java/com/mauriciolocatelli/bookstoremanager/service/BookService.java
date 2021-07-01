package com.mauriciolocatelli.bookstoremanager.service;

import com.mauriciolocatelli.bookstoremanager.dto.BookDTO;
import com.mauriciolocatelli.bookstoremanager.dto.MessageResponseDTO;
import com.mauriciolocatelli.bookstoremanager.entity.Book;
import com.mauriciolocatelli.bookstoremanager.mapper.BookMapper;
import com.mauriciolocatelli.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO){
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder().
                message("Book created with ID "+savedBook.getId()).
                build();
    }
}