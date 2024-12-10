package ru.itis.repositories;

import ru.itis.models.Chapter;
import ru.itis.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChapterRepositoryJdbcImpl implements ChapterRepository {

    @Override
    public List<Chapter> findAll() {
        List<Chapter> chapters = new ArrayList<>();
        String query = "SELECT * FROM chapters";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("name");
                String content = resultSet.getString("content");
                Long titleId = resultSet.getLong("title_id");

                chapters.add(new Chapter(id, title, content, titleId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chapters;
    }

    @Override
    public Optional<Chapter> findById(Long id) {
        String query = "SELECT * FROM chapters WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Long chapterId = resultSet.getLong("id");
                    String title = resultSet.getString("name");
                    String content = resultSet.getString("content");
                    Long titleId = resultSet.getLong("title_id");

                    Chapter chapter = new Chapter(chapterId, title, content, titleId);
                    return Optional.of(chapter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(Chapter entity) {
        String query = "INSERT INTO chapters (title_id, name, content) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, entity.getTitleId());
            statement.setString(2, entity.getTitle());
            statement.setString(3, entity.getContent());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        entity.setId(generatedKeys.getLong(1));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Chapter entity) {
        String query = "UPDATE chapters SET title_id = ?, name = ?, content = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, entity.getTitleId());
            statement.setString(2, entity.getTitle());
            statement.setString(3, entity.getContent());
            statement.setLong(4, entity.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Chapter entity) {
        removeById(entity.getId());
    }

    @Override
    public void removeById(Long id) {
        String query = "DELETE FROM chapters WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Chapter> findByTitle(Long titleId) {
        List<Chapter> chapters = new ArrayList<>();
        String query = "SELECT * FROM chapters WHERE title_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, titleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String title = resultSet.getString("name");
                    String content = resultSet.getString("content");

                    chapters.add(new Chapter(id, title, content, titleId));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chapters;
    }
}
