package ra.demoormhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.demoormhibernate.dao.IStudentDao;
import ra.demoormhibernate.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentDao studentDao;
    @RequestMapping("/add")
    public String doAdd () throws ParseException {
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        Student student = new Student(null,"Nguyễn VĂn A","Hà Nội","0948733543",sp.parse("1999-10-10"),true);
        studentDao.save(student);
        return "home";
    }
}
