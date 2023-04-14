import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class JDBC_prog {
    static final String url = "jdbc:mysql://localhost:3306/test";

    public static void main(String[] args)
            throws ClassNotFoundException {
        try {

//                Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    url, "root", "");

//                Statement stmt = conn.createStatement();


//                int result = stmt.executeUpdate("insert into student(id, name, standard, address, contact) values(1,'rachel',4,'Vapi','9876543210')");


//                if (result > 0)
//                    System.out.println("successfully inserted");
//
//                else
//                    System.out.println(
//                            "unsuccessful insertion ");

//                PreparedStatement stmt=conn.prepareStatement("insert into student values(?,?,?,?,?)");
//                stmt.setInt(1,2);//1 specifies the first parameter in the query
//                stmt.setString(2,"Vansh");
//                stmt.setInt(3, 12);
//                stmt.setString(4,"Daman");
//                stmt.setString(5, "0987654321");
//

//                System.out.println(i+" records inserted");

//            PreparedStatement stmt = conn.prepareStatement("Select * from student");
//            ResultSet rs = stmt.executeQuery();
//            System.out.println("id \t name \tstandard \taddress \tcontact \t");
//            while (rs.next()) {
//                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t\t\t"+rs.getString(4)+"\t\t"+rs.getString(5));
//            }

//                DatabaseMetaData dbmd=conn.getMetaData();
//
//                System.out.println("Driver Name: "+dbmd.getDriverName());
//                System.out.println("Driver Version: "+dbmd.getDriverVersion());
//                System.out.println("UserName: "+dbmd.getUserName());
//                System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
//                System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());

//            System.out.println("Please enter Student ID");
//            Scanner sc = new Scanner(System.in);
//            int id = sc.nextInt();
//
//            PreparedStatement stmt = conn.prepareStatement("Select * from student s where s.id = ? ");
//            stmt.setInt(1, id);
//
//            ResultSet rs = stmt.executeQuery();
//            if(rs.next()){
//                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t\t\t"+rs.getString(4)+"\t\t"+rs.getString(5));
//            }
//            else
//                System.out.println("No student exists.");

//            System.out.println("Please enter Student ID");
//            Scanner sc = new Scanner(System.in);
//            int id = sc.nextInt();
//            sc.nextLine();
//            System.out.println("Please enter Student name");
//            String newName = sc.nextLine();
//
//            String query = " Update student set name = ? where id = ? ";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setString(1, newName);
//            stmt.setInt(2, id);
//
//            int rowsAffected = stmt.executeUpdate();
//
//            if(rowsAffected == 0){
//                System.out.println("Cannot change name as invalid student id");
//            }
//            else{
//                System.out.println("Changes done successfully");
//            }

//            System.out.println("Please enter Student ID");
//            Scanner sc = new Scanner(System.in);
//            int id = sc.nextInt();
//
//            PreparedStatement stmt = conn.prepareStatement("Delete from student where id = ?");
//            stmt.setInt(1, id);
//
//            int recordsDeleted = stmt.executeUpdate();
//
//            if(recordsDeleted == 0){
//                System.out.println("No record deleted");
//            }
//            else
//                System.out.println("Record deleted successfully");




            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}


