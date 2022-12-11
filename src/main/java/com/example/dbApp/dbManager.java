package com.example.dbApp;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class dbManager {
    Statement st;
public dbManager() throws SQLException {

    getConnection();
    createTable();
}
    public Connection connection;


public Connection getConnection() throws SQLException {
    if(connection==null){
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","password");
    }
    return connection;
}
public void createTable () throws SQLException {
    String sql_query="create table if not exists student_Info(id INT primary key auto_increment,age INT, name VARCHAR(30))";
    st=connection.createStatement();
    System.out.println(st.execute(sql_query));
}
public void insertInfo(Student s) throws SQLException {
    String sql_query="insert into student_Info(age,name) value("+s.getAge()+",'"+s.getName()+"')";
    st =connection.createStatement();
    int num= st.executeUpdate(sql_query);
    System.out.println("Number of Rows affected - "+""+num);
}
public List<Student> getALL() throws SQLException {
    String sql_query="Select * from student_Info";
    st=connection.createStatement();
    ResultSet r=st.executeQuery(sql_query);
    List<Student> al=new ArrayList<>();
    while(r.next()){


        int id=Integer.parseInt(r.getString("id"));
        int age=Integer.parseInt(r.getString("age"));
        String name=r.getString("name");
        al.add(new Student(age,name));

    }return al;
}

}

