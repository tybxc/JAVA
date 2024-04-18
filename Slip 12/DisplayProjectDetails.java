import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayProjectDetails extends JFrame {
    private JTable table;

    public DisplayProjectDetails() {
        setTitle("Project Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Project ID");
        model.addColumn("Project Name");
        model.addColumn("Project Description");
        model.addColumn("Project Status");

        // Populate the table model with data from the database
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase", "yourusername", "yourpassword")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT");
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("project_id"),
                        rs.getString("project_name"),
                        rs.getString("project_description"),
                        rs.getString("project_status")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a table with the model
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the table to the frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DisplayProjectDetails frame = new DisplayProjectDetails();
            frame.setVisible(true);
        });
    }
}
