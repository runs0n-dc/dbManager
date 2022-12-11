package com.example.dbApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    dbManager db;

@PostMapping("/insert_info")
    public void insertDetails(@RequestBody Student student) throws SQLException {
    db.insertInfo(student);
}
@GetMapping("/all_info")
    public List<Student> getAllInfo() throws SQLException {
    return db.getALL();
}
}
