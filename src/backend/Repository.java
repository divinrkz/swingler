package backend;

import backend.models.*;

import java.sql.*;
import java.util.ArrayList;

public class Repository {


    public ArrayList<School> getAllSchools() {
        ArrayList<School> schools = new ArrayList<School>();
        try {
            Connection connection = DBConnection.connectToDB();

            if (connection == null) {
                System.out.println("Cannot connect to DB");
            } else {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM school";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    School school = new School();
                    school.setId(resultSet.getInt("id"));
                    school.setCode(resultSet.getString("code"));
                    school.setName(resultSet.getString("name"));
                    school.setDescription(resultSet.getString("description"));
                    school.setStatus(resultSet.getString("status"));

                    schools.add(school);
                }
            }
            return schools;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<Department> getAllDepartments() {
        ArrayList<Department> departments = new ArrayList<Department>();
        try {
            Connection connection = DBConnection.connectToDB();

            if (connection == null) {
                System.out.println("Cannot connect to DB");
            } else {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM department";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Department department = new Department();
                    department.setId(resultSet.getInt("id"));
                    department.setName(resultSet.getString("name"));
                    department.setStatus(resultSet.getString("status"));
                    department.setDescription(resultSet.getString("description"));

                    departments.add(department);
                }
            }
            return departments;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Connection connection = DBConnection.connectToDB();

            if (connection == null) {
                System.out.println("Cannot connect to DB");
            } else {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM student";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setRegistrationNumber(resultSet.getString("registration_number"));
                    student.setFirstName(resultSet.getString("first_name"));
                    student.setLastName(resultSet.getString("last_name"));
                    student.setGender(resultSet.getString("gender"));
                    student.setBirthDate(resultSet.getString("birth_date"));
                    student.setDepartmentId(resultSet.getInt("department_id"));

                    students.add(student);
                }
            }
            return students;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    public boolean saveStudent(Student student)  {
        try {
            Connection connection = DBConnection.connectToDB();
            if (connection == null) {
                System.out.println("Cannot connect to DB");
                return false;
            } else {
                String query = "INSERT into student (registration_number, first_name, last_name, gender, birth_date, department_id) VALUES (?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);

                statement.setString(1, student.getRegistrationNumber());
                statement.setString(2, student.getFirstName());
                statement.setString(3, student.getLastName());
                statement.setString(4, student.getGender());
                statement.setString(5, student.getBirthDate());
                statement.setInt(6, student.getDepartmentId());

                int row = statement.executeUpdate();
                return row == 1;

            }
        }
        catch ( Exception e) {
            e.printStackTrace();
            return  false;
        }
    }

}
