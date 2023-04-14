import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JdbcCrudOp {
    public static void insertRecord() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Student name");
            String name = sc.nextLine();
            System.out.println("Enter Student Standard");
            int std = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Student Address");
            String add = sc.nextLine();
            System.out.println("Enter Student Contact");
            String contactno = sc.nextLine();

            PreparedStatement stmt = conn.prepareStatement("Insert into student(name,standard,address,contact) values(?,?,?,?)");
            stmt.setString(1, name);
            stmt.setInt(2, std);
            stmt.setString(3, add);
            stmt.setString(4, contactno);

            int insertedRecordCount = stmt.executeUpdate();
            if (insertedRecordCount == 0)
                System.out.println("No records inserted");
            else
                System.out.println("Record inserted successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printRecordById() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            System.out.println("Please enter Student ID");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();

            PreparedStatement stmt = conn.prepareStatement("Select * from student s where s.id = ? ");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t\t\t" + rs.getString(4) + "\t\t" + rs.getString(5));
            } else
                System.out.println("No student exists.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printAllRecords() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement stmt = conn.prepareStatement("Select * from student order by id");
            ResultSet rs = stmt.executeQuery();
            System.out.println("id \t name \tstandard \taddress \tcontact \t");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t\t\t" + rs.getString(4) + "\t\t" + rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateRecord() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            System.out.println("Select field to be updated");
            System.out.println("1. Update Name");
            System.out.println("2. Update Standard");
            System.out.println("3. Update Address");
            System.out.println("4. Update Contact");

            Scanner sc = new Scanner(System.in);
            int fieldno = sc.nextInt();
            sc.nextLine();
            String attribute = null;

            switch (fieldno) {

                case 1:
                    attribute = "name";
                    break;

                case 2:
                    attribute = "standard";
                    break;

                case 3:
                    attribute = "address";
                    break;

                case 4:
                    attribute = "contact";
                    break;

                default:
                    System.out.println("Invalid selection");


            }

            System.out.println("Please enter Student ID");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Please enter new value for field selected");
            String newValue = sc.nextLine();

            String query = " Update student set " + attribute + " = ? where id = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newValue);
            stmt.setInt(2, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Cannot change name as invalid student id");
            } else {
                System.out.println("Changes done successfully");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteRecord() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            System.out.println("Please enter Student ID");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();

            PreparedStatement stmt = conn.prepareStatement("Delete from student where id = ?");
            stmt.setInt(1, id);

            int recordsDeleted = stmt.executeUpdate();

            if (recordsDeleted == 0) {
                System.out.println("No record deleted");
            } else
                System.out.println("Record deleted successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {


        System.out.println("Select operation to be performed on Student data : ");
        System.out.println("1. Insert record");
        System.out.println("2. Print record by id");
        System.out.println("3. Print records");
        System.out.println("4. Update record");
        System.out.println("5. Delete record");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                insertRecord();
                break;

            case 2:
                printRecordById();
                break;

            case 3:
                printAllRecords();
                break;

            case 4:
                updateRecord();
                break;

            case 5:
                deleteRecord();
                break;

            default:
                System.out.println("Invalid choice");

        }


    }
}
