package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerH2Repository implements CustomerRepository {

    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:~/my_db";

    private final String USER = "sa";
    private final String PASS = "";

    public CustomerH2Repository() {
        try(Connection connection = DriverManager.getConnection(DB_URL,USER,PASS)){
            String SQL = "CREATE TABLE Customer " +
                    "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                    " name VARCHAR(100), " +
                    " eMail VARCHAR(100), " +
                    " PRIMARY KEY ( id ))";

            try(PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.executeUpdate();
            }
        }catch (SQLException throwables) {
            // делать что-то;
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(DB_URL,USER,PASS)){
            String SQL = "SELECT * FROM Customer";
            try(PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
                try( ResultSet resultset = preparedStatement.executeQuery()) {
                    while (resultset.next()) {
                        Customer customer = new Customer();

                        customer.setId(resultset.getLong("id"));
                        customer.setName(resultset.getString("name"));
                        customer.setEMail(resultset.getString("eMail"));

                        customers.add(customer);
                    }
                }
            }
        } catch (SQLException throwables) {
            // делать что-то;
        }
        return customers;
    }

    @Override
    public boolean createCustomer(String name, String eMail) {

        try(Connection connection = DriverManager.getConnection(DB_URL,USER,PASS)){
            String SQL = "INSERT INTO Customer (Name, Email) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, eMail);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException throwables) {
            // делать что-то;
            return false;
        }
        return true;
    }

}


