package Database;

import sample.Book;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler {
    private final String DB_url = "jdbc:derby:database/forum;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;

    public DatabaseHandler(){
        createConnection();
        createTable();
    }

    private void createConnection(){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_url);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createTable(){
        String TABLE_NAME = "BOOKS";
        try{
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, TABLE_NAME, null);
            if(tables.next()){
                System.out.println("Table " + TABLE_NAME + " already exists");
            }else{
                String statement = "CREATE TABLE " + TABLE_NAME + " ("
                        + "id varchar(200) primary key, \n"
                        + "book_name varchar(200), \n"
                        + "name varchar(200))";
                System.out.println(statement);
                stmt.execute(statement);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage() + " setting up database");
        }
    }

    public boolean execAction(String qu){
        try{
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage(), "ERROR OCCURED", JOptionPane.ERROR_MESSAGE);
            System.out.println("exception at execQuery: " + e.getLocalizedMessage());
            return false;
        }
    }

    public ResultSet execQuery(String query){
        ResultSet resultSet;
        try{
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
        }catch (SQLException e) {
            System.out.println("Exception at Execute query");
            return null;
        }
        return resultSet;
    }

    public void add(String id, String book_name, String name){
        boolean flag = id.isEmpty() || book_name.isEmpty() || name.isEmpty();
        if (flag){
            return;
        }
        String st = "INSERT INTO BOOKS VALUES (" +
                "'" + id + "'," +
                "'" + book_name + "'," +
                "'" + name + "')";
        if(execAction(st)){
            System.out.println("info entered");
        }else{
            System.out.println("info not entered");
        }
    }

    public ArrayList<Book> getItems() throws SQLException{
        String qu = "SELECT * FROM BOOKS";
        ResultSet rs = execQuery(qu);
        ArrayList<Book> books = new ArrayList<>();

        while (rs.next()){
            String id  = rs.getString("id");
            String book_name  = rs.getString("book_name");
            String name = rs.getString("name");
            books.add(new Book(id, book_name, name));
        }
        return books;
    }

    public void remove(String id){
        boolean flag = id.isEmpty();
        if (flag){
            return;
        }
        String st = "DELETE FROM BOOKS WHERE ID =(" +
                "'" + id + "')";
        if(execAction(st)){
            System.out.println("info removed");
        }else{
            System.out.println("info not removed");
        }
    }
}
