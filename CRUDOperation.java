package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDOperation {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/demo_schema";
        String userName = "root";
        String password = "Guru@1921";

        Connection connection = DriverManager.getConnection(url, userName, password);

        System.out.println("Enter 1 For To Get All Student Data ");
        System.out.println("Enter 2 For To Get Specific Student Data ");
        System.out.println("Enter 3 For To Save Student Data ");
        System.out.println("Enter 4 For To Update Student Data ");
        System.out.println("Enter 5 For To Delete Student Data ");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Choice : ");
        int input = sc.nextInt();

        switch (input) {

            case 1:
                String sql1 = "SELECT * FROM student";
                Statement st1 = connection.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);

                while (rs1.next()) {
                    System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + " " + rs1.getString(3));
                }
                break;

            case 2:
                System.out.print("Enter Student Id : ");
                int id = sc.nextInt();

                String sql2 = "SELECT * FROM student WHERE id = " + id;
                Statement st2 = connection.createStatement();
                ResultSet rs2 = st2.executeQuery(sql2);

                while (rs2.next()) {
                    System.out.println(rs2.getInt(1) + " " + rs2.getString(2) + " " + rs2.getString(3));
                }
                break;

            case 3:
                System.out.print("Enter Student Id : ");
                int id3 = sc.nextInt();

                System.out.print("Enter Student Name : ");
                String name3 = sc.next();

                String sql3 = "INSERT INTO student VALUES (" + id3 + ", '" + name3 + "')";
                Statement st3 = connection.createStatement();
                st3.executeUpdate(sql3);

                System.out.println("Student Data Inserted Successfully");
                break;

            case 4:
                System.out.print("Enter New Name : ");
                String name1 = sc.next();

                System.out.print("Enter Student Id : ");
                int id1 = sc.nextInt();

                String sql4 = "UPDATE student SET name = '" + name1 + "' WHERE id = " + id1;
                Statement st4 = connection.createStatement();
                st4.executeUpdate(sql4);

                System.out.println("Student Data Updated Successfully");
                break;

            case 5:
                System.out.print("Enter Student Id To Delete : ");
                int id2 = sc.nextInt();

                String sql5 = "DELETE FROM student WHERE id = " + id2;
                Statement st5 = connection.createStatement();
                st5.executeUpdate(sql5);

                System.out.println("Student Data Deleted Successfully");
                break;

            default:
                System.out.println("Enter a Valid Input");
        }

        connection.close();
        sc.close();
    }
}
