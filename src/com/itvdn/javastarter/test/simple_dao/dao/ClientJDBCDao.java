package com.itvdn.javastarter.test.simple_dao.dao;

import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 29.10.2020.
 */
public class ClientJDBCDao extends AbstractDao implements ClientDAO {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/carsshop?serverTimezone=UTC";
    public static final  String USERNAME = "sayut61";
    public static final String PASSWORD = "Sunk@r61_093";
    @Override
    protected Connection getConnection() {
        return super.getConnection();
    }

    @Override
    public List<Client> getAll() {
        Connection connection = null;
        Statement statement = null;
        List<Client> clients = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                Client client = new Client();
                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                clients.add(client);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return clients;
    }

    @Override
    public int insert(Client client) {
        return 0;
    }

    @Override
    public int delete(Client client) {
        return 0;
    }

    @Override
    public Client getById(int id) {
        return null;
    }
}
