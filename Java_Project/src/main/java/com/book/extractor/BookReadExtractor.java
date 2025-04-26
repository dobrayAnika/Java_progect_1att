package com.book.extractor;

import com.book.model.BookRead;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookReadExtractor {
    public static BookRead extract(ResultSet rs) {
        try {
            return new BookRead(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getInt("book_id"),
                    rs.getString("book_title")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
