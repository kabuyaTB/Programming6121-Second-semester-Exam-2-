
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * Q.2.1, Q.2.2, Q.2.3: The GUI Application
 */
public class ProductSalesGUI extends JFrame {

    // Components
    private final JButton btnLoadData;
    private final JButton btnSaveData;
    private final JTextArea txtDataLog;
    private final JLabel lblYearsProcessed;

    private final JMenuBar menuBar;
    private final JMenu menuFile;
    private final JMenuItem itemExit;
    private final JMenuItem itemLoadData;
    private final JMenuItem itemSaveData;
    private final JMenuItem itemClear;

    // Data processing class from Q.2.4
    private final ProductSales salesCalculator;

    public ProductSalesGUI() {
        // --- Basic Frame Setup ---
        this.setTitle("Product Sales Application");
        this.setSize(450, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));

        salesCalculator = new ProductSales();

        // --- 1. Center Panel (Q.2.1 - Text Area) ---
        txtDataLog = new JTextArea();
        txtDataLog.setEditable(false); // "read-only"
        txtDataLog.setBorder(new EmptyBorder(5, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(txtDataLog);
        this.add(scrollPane, BorderLayout.CENTER);

        // --- 2. Bottom Panel (Q.2.1 - Buttons and Label) ---
        JPanel southPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        btnLoadData = new JButton("Load Product Data");
        btnSaveData = new JButton("Save Product Data");
        buttonPanel.add(btnLoadData);
        buttonPanel.add(btnSaveData);

        // "read-only label to display the number of years"
        lblYearsProcessed = new JLabel("Years Processed: 0"); 
        lblYearsProcessed.setBorder(new EmptyBorder(5, 10, 5, 5));
        
        southPanel.add(buttonPanel, BorderLayout.NORTH);
        southPanel.add(lblYearsProcessed, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        // --- 3. Top Panel (Q.2.3 - Menu System) ---
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        
        itemLoadData = new JMenuItem("Load Product Data");
        itemSaveData = new JMenuItem("Save Product Data");
        itemClear = new JMenuItem("Clear");
        itemExit = new JMenuItem("Exit");

        menuFile.add(itemLoadData);
        menuFile.add(itemSaveData);
        menuFile.add(itemClear);
        menuFile.addSeparator();
        menuFile.add(itemExit);
        menuBar.add(menuFile);
        this.setJMenuBar(menuBar);

        // --- 4. Add Event Listeners (Q.2.2, Q.2.3) ---
        
        // Action listener for loading data
        ActionListener loadAction = (ActionEvent e) -> {
            loadData();
        };
        btnLoadData.addActionListener(loadAction);
        itemLoadData.addActionListener(loadAction);

        // Action listener for saving data
        ActionListener saveAction = (ActionEvent e) -> {
            saveData();
        };
        btnSaveData.addActionListener(saveAction);
        itemSaveData.addActionListener(saveAction);

        // Action listener for clearing
        itemClear.addActionListener((ActionEvent e) -> {
            clearData();
        });

        // Action listener for exiting
        itemExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    /**
     * Q.2.2 - "load the product sales data from memory"
     * This uses the ProductSales class to get values.
     */
    private void loadData() {
        int total = salesCalculator.GetTotalSales();
        double avg = salesCalculator.GetAverageSales();
        int years = salesCalculator.GetProductSales().length;
        int under = salesCalculator.GetSalesUnderLimit();
        int over = salesCalculator.GetSalesOverLimit();

        // Build the report string
        String report = "DATA LOG\n";
        report += "----------------------\n";
        // Use \t (tab) for alignment
        report += String.format("Total Sales: \t\t%d%n", total);
        report += String.format("Average Sales: \t\t%.2f%n", avg);
        report += String.format("Years processed: \t%d%n", years);
        report += String.format("Sales under limit: \t%d%n", under);
        report += String.format("Sales over limit: \t%d%n", over);

        txtDataLog.setText(report);
        lblYearsProcessed.setText("Years Processed: " + years);
    }

    /**
     * Q.2.2 - "save the information... to a file named data.txt"
     */
    private void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt"))) {
            writer.print(txtDataLog.getText());
            txtDataLog.append("\n\n--- Data successfully saved to data.txt ---");
        } catch (Exception e) {
            txtDataLog.append("\n\n--- ERROR SAVING FILE: " + e.getMessage() + " ---");
        }
    }

    /**
     * Q.2.3 - "remove the items in the text area and clear the Years Processed label"
     */
    private void clearData() {
        txtDataLog.setText("");
        lblYearsProcessed.setText("Years Processed: 0");
    }

    // --- Main method to run the GUI ---
    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new ProductSalesGUI().setVisible(true);
        });
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
