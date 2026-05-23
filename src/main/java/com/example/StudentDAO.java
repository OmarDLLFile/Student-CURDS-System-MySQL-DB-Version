package com.example;
import java.sql.*;
import java.util.Scanner;

public class StudentDAO {

    Connection conn;

    public StudentDAO() {
        conn = DBConnection.getConnection();
    }

    public void addStudent(String name, int age, String grade) {
        try {
            String query = "INSERT INTO students(name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, grade);

            ps.executeUpdate();
            System.out.println("Student added successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showStudents() {
        try {
            String query = "SELECT * FROM students";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("age") + " | " +
                    rs.getString("grade")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        try {
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Deleted successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchStudent(int id) {
        try {
            String query = "SELECT * FROM students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("age") + " | " +
                    rs.getString("grade")
                );
            } else {
                System.out.println("Student not found");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateStudent (int student_id, String student_new_name, int student_new_age, int student_new_grade) {
        try {

            PreparedStatement sql = conn.prepareStatement("update students set name=?, age=?, grade=? where id=?");
            sql.setString(1, student_new_name);
            sql.setInt(2, student_new_age);
            sql.setInt(3, student_new_grade);
            sql.setInt(4, student_id);

            sql.executeUpdate();
            System.out.println("Student Data Updated Sucessfully");
            
        }catch (Exception e){
            System.out.println("Failed: " + e.getMessage());
        }
    }
}