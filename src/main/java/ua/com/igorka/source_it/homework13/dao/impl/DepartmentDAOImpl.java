package ua.com.igorka.source_it.homework13.dao.impl;

import ua.com.igorka.source_it.homework13.connector.DBConnector;
import ua.com.igorka.source_it.homework13.dao.DepartmentDAO;
import ua.com.igorka.source_it.homework13.dao.EmployeeDAO;
import ua.com.igorka.source_it.homework13.entity.Department;
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
public class DepartmentDAOImpl implements DepartmentDAO {

    private DBConnector dbConnector;
    private Connection connection;

    {
        dbConnector = DBConnector.getInstance();
    }

    @Override
    public boolean insert(Department object) throws SQLException {

        String request = "INSERT INTO department (name) values (?)";

        connection = dbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(request);

        statement.setString(1, object.getName());
        statement.executeUpdate();

        statement.close();
        connection.close();
        return true;
    }

    @Override
    public List<Department> selectAll() throws SQLException {
        String request = "SELECT * FROM department";

        connection = dbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(request);

        List<Department> listDepartments;

        ResultSet resultSet = statement.executeQuery();

        listDepartments = getDepartmentListFromResultSet(resultSet);

        resultSet.close();
        statement.close();
        connection.close();

        return listDepartments;
    }

    @Override
    public Department selectById(Long id) throws SQLException {
        String request = "SELECT * FROM department where id = ?";

        connection = dbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(request);

        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();

        Department department = new Department();

        while (resultSet.next()) {
            department = getDepartmentFromResultSet(resultSet);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return department;
    }

    @Override
    public boolean update(Department object) throws SQLException {
        String request = "UPDATE department SET name = ? where id = ?";

        connection = dbConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(request);

        statement.setString(1, object.getName());
        statement.setLong(2, object.getId());

        statement.executeUpdate();

        statement.close();
        connection.close();
        return true;
    }

    @Override
    public boolean delete(Department object) throws SQLException {
        return deleteById(object.getId());
    }

    @Override
    public boolean deleteById(Long id) throws SQLException {
        connection = dbConnector.getConnection();

        String request = "delete from department where id = ?";

        PreparedStatement statement = connection.prepareStatement(request);

        statement.setLong(1, id);

        statement.executeUpdate();

        statement.close();
        connection.close();
        return true;
    }

    public Department readByEmployeeId(Long employeeId) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = employeeDAO.selectById(employeeId);

        return this.selectById(employee.getDepartmentId());
    }

    private List<Department> getDepartmentListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Department> listDepartment = new ArrayList<>();
        while (resultSet.next()) {
            listDepartment.add(getDepartmentFromResultSet(resultSet));
        }
        return listDepartment;
    }

    private Department getDepartmentFromResultSet(ResultSet resultSet) throws SQLException{
        Department department = new Department();
        department.setId(resultSet.getLong("id"));
        department.setName(resultSet.getString("name"));
        return department;
    }
}
