package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private String name;
    @JsonIgnore
    private Person teacher;
    private int maxEnrollment;
    private int credits;

    @JsonIgnore
    private List<Student> studentsEnrolled;

    public Course() {
    }


    public Course(String name, Person teacher, int maxEnrollment, List<Student> studentsEnrolled, int credits) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrollment = maxEnrollment;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return maxEnrollment == course.maxEnrollment && credits == course.credits && Objects.equals(name, course.name) && Objects.equals(teacher, course.teacher) && Objects.equals(studentsEnrolled, course.studentsEnrolled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teacher, maxEnrollment, studentsEnrolled, credits);
    }

    /**
     *
     * @return list with the names of the students
     */
    public List<String> getStudentsNames(){
        List<String> studentsList = new ArrayList<>();
        for (Student s : studentsEnrolled){
            String name = s.getLastName() + " " + s.getFirstName();
            studentsList.add(name);
        }
        return studentsList;
    }

    public String getTeacherName(){
        return teacher.getLastName() + " " + teacher.getFirstName();
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacherName='" + getTeacherName() + '\'' +
                ", maxEnrollment=" + maxEnrollment +
                ", studentsEnrolled=" + getStudentsNames() +
                ", credits=" + credits +
                '}';
    }
}
