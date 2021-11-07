import controller.StudentController;
import model.Course;
import model.Student;
import model.Teacher;
import repository.CourseFileRepository;
import repository.StudentFileRepository;
import repository.TeacherFileRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        Teacher teacher1 = new Teacher("Catalin", "Rusu", new ArrayList<>());
        TeacherFileRepository teacherRepo = new TeacherFileRepository(new File("data.json"));

        Course course1 = new Course("MAP", teacher1, 70, new ArrayList<>(), 6);
        Course course2 = new Course("BD", teacher1, 80, new ArrayList<>(), 6);
//        teacher1.getCourses().add(course1);
//        teacher1.getCourses().add(course2);
//        teacherRepo.create(teacher1);
        Student student1 = new Student("Paul", "Tarta", 456, 0, new ArrayList<>());

        Student student2 = new Student("Andrei", "Silion", 457, 0,new ArrayList<>());




        StudentFileRepository studentRepo = new StudentFileRepository(new File("data3.json"));


        CourseFileRepository courseRepo = new CourseFileRepository(new File("data2.json"), teacherRepo, studentRepo);
//        course1.getStudentsEnrolled().add(student1);
//        course1.getStudentsEnrolled().add(student2);
//        courseRepo.create(course1);
//        courseRepo.create(course2);
//
//        student1.getEnrolledCourses().add(course1);
//        student2.getEnrolledCourses().add(course1);
//        studentRepo.create(student1);
//        studentRepo.create(student2);

        System.out.println(courseRepo.getAll());
        StudentController studentController = new StudentController(studentRepo);
        System.out.println(studentController.obtainObjects());

        //System.out.println(courseRepo.getAll());
    }
}
