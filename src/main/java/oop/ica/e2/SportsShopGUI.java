/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oop.ica.e2;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Raj
 */
public class SportsShopGUI extends javax.swing.JFrame {
    
    private static final ArrayList<ASCStockItem> storedData = new ArrayList<>();
    private static final String DELIMITER = ",";
    private static ASCTableModel ascModel;
    private String[] columnNames = new String[]{"Product Code","Title","Description","Price","Stock"};

    /**
     * Creates new form SportsShopGUI
     */
    public SportsShopGUI() {
        initComponents();
        
        try{
           loadData();
           loadSkatesData();
        }
        catch (FileNotFoundException e){
            System.out.println("Unable to open file " + e.getMessage() + "\n");
            System.exit(0); 
        }
        
        catch (IOException e){
            System.out.println("File read error" + e.getMessage() + "\n");
            System.exit(0);
        }
        
        ascModel = new ASCTableModel (columnNames , storedData);
        
        ascStockItem.setModel(ascModel);
        
        for (int col = 0; col < ascStockItem.getColumnCount(); col++) {
            //reference current column
            TableColumn column = ascStockItem.getTableHeader().getColumnModel().getColumn(col);

            //set column header
            column.setHeaderValue(columnNames[col]);
        }
        


        ascStockItem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                
                int selectedRow = ascStockItem.getSelectedRow();
                ASCStockItem item = storedData.get(selectedRow);
                ascStockItem.repaint();
                
                if (item.stockQuantity() < 5){
                    JOptionPane.showMessageDialog(null,item.itemTitle() + " has only " + item.stockQuantity() + " units"
                    , "Low Stock Warning" , JOptionPane.WARNING_MESSAGE);
                }
                
                
                if (selectedRow == -1){
                    itemLabel.setText("Image Not available.");
                }
                else{
                    ImageIcon icon = new ImageIcon("photos/" + item.itemCode() + ".jpg");
                    photoLabel.setIcon(icon);
                    itemLabel.setText(item.itemTitle());
                }
          
            }

        });
   }
        
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ascStockItem = new javax.swing.JTable();
        buyButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        buyXButton = new javax.swing.JButton();
        addYButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        photoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        photoLabel = new javax.swing.JLabel();
        itemLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ascStockItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ascStockItem);

        buyButton.setText("Buy");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        buyXButton.setText("Buy X");
        buyXButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyXButtonActionPerformed(evt);
            }
        });

        addYButton.setText("Add Y");
        addYButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addYButtonActionPerformed(evt);
            }
        });

        quitButton.setBackground(new java.awt.Color(255, 0, 0));
        quitButton.setForeground(new java.awt.Color(255, 255, 255));
        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        photoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Item Photo");

        photoLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        itemLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout photoPanelLayout = new javax.swing.GroupLayout(photoPanel);
        photoPanel.setLayout(photoPanelLayout);
        photoPanelLayout.setHorizontalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(photoPanelLayout.createSequentialGroup()
                .addGroup(photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(photoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(photoPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        photoPanelLayout.setVerticalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(photoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(itemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buyButton)
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(buyXButton)
                        .addGap(18, 18, 18)
                        .addComponent(addYButton)
                        .addGap(18, 18, 18)
                        .addComponent(quitButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buyButton)
                            .addComponent(addButton)
                            .addComponent(buyXButton)
                            .addComponent(addYButton)
                            .addComponent(quitButton))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        // TODO add your handling code here:
        buyItem();
    }//GEN-LAST:event_buyButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        addItem();
    }//GEN-LAST:event_addButtonActionPerformed

    private void buyXButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyXButtonActionPerformed
        // TODO add your handling code here:
        buyXItems();
    }//GEN-LAST:event_buyXButtonActionPerformed

    private void addYButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addYButtonActionPerformed
        // TODO add your handling code here:
        addYItems();
    }//GEN-LAST:event_addYButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // TODO add your handling code here:
        try{
            saveData(storedData);
             JOptionPane.showMessageDialog(null , "Thanks for the visit.." , "stock stored in asc_output.txt" ,JOptionPane.INFORMATION_MESSAGE );
        
            System.exit(0);
        }

        catch (FileNotFoundException e){
            System.out.println("Error" + e.getMessage() + "\n");
            System.exit(0);
        }
        
        catch (IOException e){
            System.out.println("Error" + e.getMessage() + "\n");
            System.exit(0);
        }
        
        JOptionPane.showMessageDialog(null , "Thanks for the visit.." , "stock stored in asc_output.txt" ,JOptionPane.INFORMATION_MESSAGE );
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SportsShopGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SportsShopGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SportsShopGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SportsShopGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SportsShopGUI().setVisible(true);
            }
        });
    }
    
        // loadData method used to catch data
    private ArrayList loadData() throws FileNotFoundException, IOException {
        String input = "AsherSportsConsortium3.csv";
        String pathname = input;
        File inputFile = new File(pathname);

        if (!inputFile.exists() || !inputFile.isFile()) {
            throw new FileNotFoundException("Stock Items data file (" + input + ") does not exist as a data file.");
        }

        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] lineArray = line.split(",");
                    String productCode = lineArray[0];
                    String title = lineArray[1];
                    String description = lineArray[2];
                    int unitPricePounds = Integer.parseInt(lineArray[3]);
                    int unitPricePence = Integer.parseInt(lineArray[4]);
                    int quantityOnStock = Integer.parseInt(lineArray[5]);
                    ASCStockItem sport = new ASCStockItem(
                            productCode, title,
                            description, unitPricePounds,
                            unitPricePence, quantityOnStock
                    );
                    storedData.add(sport);
                }
            }
            fileScanner.close();
        }
        if (storedData.isEmpty()) {
            throw new FileNotFoundException("Stock Items data file AsherSportsConsortium.csv is empty.");
        }
        return storedData;
    }
    
    public static void buyItem() {
        int option;
        option = ascStockItem.getSelectedRow();
        
        if (option == -1){
            JOptionPane.showMessageDialog(null, "Please select an item from the table.","No item selected", JOptionPane.ERROR_MESSAGE);
        }
        
        ASCStockItem item = storedData.get(option);
        
        //stops the decrementing counter when quantity reaches 0
        if (item.stockQuantity()==0){
            JOptionPane.showMessageDialog(null, "Item out of stock","No sufficient items", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        item.setQuantity(item.stockQuantity()-1);
        ascModel.setValueAt(item.stockQuantity(),option,4);
        
        JOptionPane.showMessageDialog(null, "Item: "+ item.itemTitle() + "\nPrice: £" + item.itemPrice() 
                + "\nUnits bought: 1" + "\nStock remaining: "+ item.stockQuantity(),"Sale Confirmed", 
                JOptionPane.INFORMATION_MESSAGE);
        
        if (item.stockQuantity() < 5){
            JOptionPane.showMessageDialog(null,item.itemTitle() + " has only " + item.stockQuantity() + " units left."
                    , "Low Stock Warning" , JOptionPane.WARNING_MESSAGE);
        }
        
        
        
    }
    
    public static void addItem() {
    
        int option;
        option = ascStockItem.getSelectedRow();
        
        if (option == -1){
            JOptionPane.showMessageDialog(null, "Please select an item from the table.","No item selected", JOptionPane.ERROR_MESSAGE);
        }
        
        ASCStockItem item = storedData.get(option);
        
        item.setQuantity(item.stockQuantity()+1);
        ascModel.setValueAt(item.stockQuantity(),option,4);
        
        JOptionPane.showMessageDialog(null, "Item: "+ item.itemTitle() + "\nAdded: 1" 
                + "\nNew Quantity: "+ item.stockQuantity(),"Items are added", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void buyXItems() {
        int row;
        row = ascStockItem.getSelectedRow();
        
        if (row == -1){
            JOptionPane.showMessageDialog(null, "Please select an item from the table.","No item selected", JOptionPane.ERROR_MESSAGE);
        }
        
        ASCStockItem item = storedData.get(row);
        
        if (item.stockQuantity()==0){
            JOptionPane.showMessageDialog(null, "Item out of stock","No sufficient items", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Integer [] options = new Integer[ item.stockQuantity() ]; 
        for (int index = 1; index <= item.stockQuantity(); index++)
        {
        options [index - 1] = index; 

        }
        Object inputString = JOptionPane.showInputDialog( null, "Please select a value","Buy multiple items"
                , JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        int selectedOption = (Integer)inputString;
        
        item.setQuantity(item.stockQuantity() - selectedOption);
        ascModel.setValueAt(item.stockQuantity() , row , 4);
        
        JOptionPane.showMessageDialog(null, "Item: "+ item.itemTitle() 
                + "\nUnits bought: " + selectedOption + "\nRemaining stock: "+ item.stockQuantity(),"Sale Confirmed", 
                JOptionPane.INFORMATION_MESSAGE);  
    }
    
    public static void addYItems() {
        int row;
        row = ascStockItem.getSelectedRow();
        
        if (row == -1){
            JOptionPane.showMessageDialog(null, "Please select an item from the table.","No item selected", JOptionPane.ERROR_MESSAGE);
        }
        
        ASCStockItem item = storedData.get(row);
        
        Integer [] options = new Integer[ 6 ]; 
        
        for (int index = 5; index <= 10; index++)
        {
        options [index - 5] = index; 

        }
        Object inputString = JOptionPane.showInputDialog( null, "Please select a value","Add multiple items."
                , JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        int selectedOption = (Integer)inputString;
        item.setQuantity(item.stockQuantity() + selectedOption);
        ascModel.setValueAt(item.stockQuantity() , row , 4);
        
        JOptionPane.showMessageDialog(null, "Item: "+ item.itemTitle() 
                + "\nNumber of units added: " + selectedOption + "\nNew quantity: "+ item.stockQuantity(),"Items are added.", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void loadSkatesData() throws IOException, FileNotFoundException{
        
        final String INPUT_FILE_PATH = "ts_products.txt";
        File inputFile = new File(INPUT_FILE_PATH);
        Scanner fileScanner;
        
        if (inputFile.exists() && inputFile.isFile()){
            fileScanner = new Scanner(inputFile);
            
            while (fileScanner.hasNextLine()){
                
                String line = fileScanner.nextLine().trim();
                
                if (!line.isEmpty()){
                    String productCode = line.split(DELIMITER)[0];
                    String title = line.split(DELIMITER)[1]+" "+line.split(DELIMITER)[2];
                    String description = line.split(DELIMITER)[4];
                    double price = Double.parseDouble(line.split(DELIMITER)[5]);
                    int pounds = (int)price;
                    int pence = (int)((price - pounds)*100);
                    int quantity = Integer.parseInt(line.split(DELIMITER)[6]);
                    
                    storedData.add(new ASCStockItem(productCode,title,description,pounds,pence,quantity));    
                }    
            }
            
            fileScanner.close();
        }
        
        else if (!inputFile.exists()){
            throw new FileNotFoundException();
            
        }
        
    }
    
    
    public void  saveData(ArrayList<ASCStockItem> storedData) throws IOException {
        
        if (storedData.isEmpty()) {
            return;
        }
        String output = "asc_output.txt";
        String pathname = output;
        Path path = Paths.get(pathname);
        Files.deleteIfExists(path);
        BufferedOutputStream buffer = new BufferedOutputStream(
                Files.newOutputStream(path, CREATE, WRITE)
        );
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < storedData.size(); i++) 
        {
            ASCStockItem item = storedData.get(i);
            String fileoutput = item.itemCode +","+ item.itemTitle+","+item.priceInPounds+","+item.priceInPence+","+item.stockQuantity + "\n";
            sb.append(fileoutput);
        }
        
        byte outputStringBytes[] = sb.toString().getBytes();
        buffer.write(outputStringBytes, 0, outputStringBytes.length);
        buffer.close();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addYButton;
    private static javax.swing.JTable ascStockItem;
    private javax.swing.JButton buyButton;
    private javax.swing.JButton buyXButton;
    private static javax.swing.JLabel itemLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel photoLabel;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JButton quitButton;
    // End of variables declaration//GEN-END:variables
}
