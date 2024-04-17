import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CollegeDetailsJTable extends JFrame {
    private JTable collegeTable;
    private JScrollPane scrollPane;

    public CollegeDetailsJTable() {
        setTitle("College Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Sample data for the table
        Object[][] data = {
                {1, "ABC College", "123 Main St, City", 2020},
                {2, "XYZ College", "456 Oak St, Town", 2018},
                // Add more rows as needed
        };

        // Column names for the table
        String[] columnNames = {"CID", "CName", "Address", "Year"};

        // Create a default table model with the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        collegeTable = new JTable(model);

        // Set preferred column widths (optional)
        collegeTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        collegeTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        collegeTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        collegeTable.getColumnModel().getColumn(3).setPreferredWidth(100);

        // Create a scroll pane and add the table to it
        scrollPane = new JScrollPane(collegeTable);

        // Add the scroll pane to the frame
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Create and display the frame
        SwingUtilities.invokeLater(() -> {
            CollegeDetailsJTable frame = new CollegeDetailsJTable();
            frame.setVisible(true);
        });
    }
}
