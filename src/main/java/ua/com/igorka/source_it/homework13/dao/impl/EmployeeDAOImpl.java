package ua.com.igorka.source_it.homework13.dao.impl;

import ua.com.igorka.source_it.homework13.connector.DBConnector;
import ua.com.igorka.source_it.homework13.dao.EmployeeDAO;
import ua.com.igorka.source_it.homework13.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 15.11.14
 * Project name: FirstJSP
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private DBConnector dbConnector;
    private Connection connection;

    {
        dbConnector = DBConnector.getInstance();
    }
    @Override
    public boolean insert(Employee object) throws SQLException {
        connection = dbConnector.getConnection();

        String request = "insert into employer (name, age, e_mail, department_id) "
                + "values (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(request);

        statement.setString(1, object.getName());
        statement.setInt(2, object.getAge());
        statement.setString(3, object.getEmail());
        statement.setLong(4, object.getDepartmentId());

        statement.executeUpdate();

        statement.close();
        connection.close();
        return true;
    }

    @Override
    public List<Employee> selectAll() throws SQLException {
        connection = dbConnector.getConnection();

        String request = "select * from employer";

        PreparedStatement statement = connection.prepareStatement(request);

        List<Employee> listEmployer;

        ResultSet resultSet = statement.executeQuery();

        listEmployer = getEmployeeListFromResultSet(resultSet);

        resultSet.close();
        statement.close();
        connection.close();

        return listEmployer;
    }

    @Override
    public Employee selectById(Long id) throws SQLException {
        connection = dbConnector.getConnection();

        String request = "select * from employer where "
                + "id = ?";

        PreparedStatement statement = connection.prepareStatement(request);

        statement.setLong(1, id);

        Employee employee = new Employee();

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            employee = getEmployeeFromResultSet(resultSet);
        }

        resultSet.close();
        statement.close();
        connection.close();
        return employee;
    }

    @Override
    public boolean update(Employee object) throws SQLException {
        connection = dbConnector.getConnection();

        String request = "update employer set name = ?,"
                + " age = ?, e_mail = ?, department_id = ?"
                + " where id = ?";

        PreparedStatement statement = connection.prepareStatement(request);

        statement.setString(1, object.getName());
        statement.setInt(2, object.getAge());
        statement.setString(3, object.getEmail());
        statement.setLong(4, object.getDepartmentId());
        statement.setLong(5, object.getId());

        statement.executeUpdate();

        statement.close();
        connection.close();
        return true;
    }

    @Override
    public boolean delete(Employee object) throws SQLException {
        return deleteById(object.getId());
    }

    @Override
    public boolean deleteById(Long id) throws SQLException {
        connection = dbConnector.getConnection();

        String request = "delete from employer where id = ?";

        PreparedStatement statement = connection.prepareStatement(request);

        statement.setLong(1, id);

        statement.executeUpdate();

        statement.close();
        connection.close();
        return true;
    }

    private List<Employee> getEmployeeListFromResultSet(ResultSet resultSet) throws SQLException{

        List<Employee> listEmployee = new ArrayList<>();

        while (resultSet.next()) {
            listEmployee.add(getEmployeeFromResultSet(resultSet));
        }

        return listEmployee;
    }

    private Employee getEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setName(resultSet.getString("name"));
        employee.setAge(resultSet.getInt("age"));
        employee.setEmail(resultSet.getString("e_mail"));
        employee.setDepartmentId(resultSet.getLong("department_id"));
        return employee;
    }
}
