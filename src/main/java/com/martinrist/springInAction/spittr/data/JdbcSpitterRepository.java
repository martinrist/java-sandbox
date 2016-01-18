package com.martinrist.springInAction.spittr.data;

import com.martinrist.springInAction.spittr.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 * Implementation of the SpitterRepository interface that is backed by a
 * persistent database store.  Access to the database store is via
 * Spring's JdbcTemplate.
 */
@Repository
@Primary
public class JdbcSpitterRepository implements SpitterRepository {

    private JdbcOperations jdbcOperations;

    private static final String SQL_INSERT_SPITTER = "insert into spitter (firstname, lastname, username, password)" +
            "values (?, ?, ?, ?)";

    private static final String SQL_FIND_BY_USERNAME = "select spitter_id, firstname, lastname, username, password from spitter where username = ?";

    @Autowired
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Spitter save(Spitter spitter) {

        jdbcOperations.update(SQL_INSERT_SPITTER, spitter.getFirstName(), spitter.getLastName(),
                spitter.getUsername(), spitter.getPassword());

        return spitter;
    }

    @Override
    public Spitter findByUserName(String username) {

        return jdbcOperations.queryForObject(SQL_FIND_BY_USERNAME,
                (rs, rowNum) -> new Spitter(rs.getLong("spitter_id"),
                                            rs.getString("firstname"),
                                            rs.getString("lastname"),
                                            rs.getString("username"),
                                            rs.getString("password")), username);
    }
}
