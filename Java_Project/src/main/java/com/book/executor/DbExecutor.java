package com.book.executor;

import com.book.db.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DbExecutor {
    private static DbExecutor instance;

    private DbExecutor() {
    }

    public static DbExecutor getInstance() {
        if (instance == null) {
            instance = new DbExecutor();
        }
        return instance;
    }

    public <T> List<T> query(String sql, Function<ResultSet, T> extractor, Object... params) {
        List<T> result = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.add(extractor.apply(rs));
                }
            }

        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    public void update(String sql, Object... params) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Ошибка при обновлении: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
