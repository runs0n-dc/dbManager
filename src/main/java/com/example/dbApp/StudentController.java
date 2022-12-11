package com.example.dbApp;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
//@Slf4j
public class StudentController {
    @Autowired
    dbManager db;
    Logger logger=LoggerFactory.getLogger(StudentController.class);

@PostMapping("/insert_info")
    public void insertDetails(@RequestBody Student student) throws SQLException {
    db.insertInfo(student);
}
@GetMapping("/all_info")

    public List<Student> getAllInfo() throws SQLException {
    logger.info("Kaam_CHALU_HAI");
    return db.getALL();
}
}
