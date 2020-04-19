package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;
import org.apache.commons.lang3.ArrayUtils;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = {};

    @Override
    public boolean save(SchoolBook book) {
        schoolBooks = ArrayUtils.add(schoolBooks, book);
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] findedBooks = {};
        for (SchoolBook schoolBook : schoolBooks) {
            if (schoolBook.getName().equalsIgnoreCase(name)) {
                findedBooks = ArrayUtils.add(findedBooks, schoolBook);
            }
        }
        return findedBooks;
    }

    @Override
    public boolean removeByName(String name) {
        if (findByName(name) == null) {
            return false;
        }
        SchoolBook[] newSchoolBook = new SchoolBook[count() - findByName(name).length];
        for (int i = 0; i < count(); i++) {
            if (!schoolBooks[i].getName().equals(name)) {
                newSchoolBook[i] = schoolBooks[i];

            }
        }
        schoolBooks = newSchoolBook;
        return true;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
