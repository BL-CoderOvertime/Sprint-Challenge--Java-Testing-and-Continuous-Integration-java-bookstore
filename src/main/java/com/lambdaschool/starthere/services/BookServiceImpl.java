package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.models.Wrote;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookrepos;


    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book findBookById(long id) {
        return bookrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public void delete(long id) {
        bookrepos.deleteById(id);
    }

    @Transactional
    @Override
    public Book save(Book book) {
        return bookrepos.save(book);
    }

    @Override
    public Book update(Book updateBook, long id) {

        Book currentBook = bookrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (updateBook.getCopy() != null) {
            currentBook.setCopy(updateBook.getCopy());
        }

        if (updateBook.getISBN() != null) {
            currentBook.setISBN(updateBook.getISBN());
        }
        currentBook.setSectionid(updateBook.getSectionid());

        if (updateBook.getTitle() != null) {
            currentBook.setTitle(updateBook.getTitle());
        }



        if (currentBook.getWrote().size() > 0) {
            for (Wrote w : updateBook.getWrote()) {
                currentBook.getWrote().add(new Wrote(currentBook, w.getAuthor()));
            }
        }

        return bookrepos.save(currentBook);
    }
}
