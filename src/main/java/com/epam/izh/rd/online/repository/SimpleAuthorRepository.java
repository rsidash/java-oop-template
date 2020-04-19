package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;
import org.apache.commons.lang3.ArrayUtils;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = {};

    @Override
    public boolean save(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) != null) {
            return false;
        }

        authors = ArrayUtils.add(authors, author);

        return true;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (Author value : authors) {
            if (value.getName().equals(name) && value.getLastName().equals(lastname)) {
                return value;
            }
        }

        return null;
    }

    @Override
    public boolean remove(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) != null) {
            authors = ArrayUtils.removeElement(authors, author);
            return true;
        }

        return false;
    }

    @Override
    public int count() {
        return authors.length;
    }
}
