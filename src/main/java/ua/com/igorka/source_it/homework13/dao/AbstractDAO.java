package ua.com.igorka.source_it.homework13.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by igor on 15.11.14
 * Project name: FirstJSP
 */
public interface AbstractDAO<T, ID> {
    boolean insert(T object) throws SQLException;

    List<T> selectAll() throws SQLException;

    T selectById(ID id) throws SQLException;

    boolean update(T object) throws SQLException;

    boolean delete(T object) throws SQLException;

    boolean deleteById(ID id) throws SQLException;
}
