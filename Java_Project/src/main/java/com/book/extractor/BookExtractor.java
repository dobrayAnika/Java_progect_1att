package com.book.extractor;

import com.book.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookExtractor {
    public static Book extract(ResultSet rs) {
        try {
            return new Book(
                    rs.getInt("id"),
                    rs.getString("title")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
