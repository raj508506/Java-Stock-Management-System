/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.e2;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raj
 */
public class ASCTableModel extends AbstractTableModel {
    
        
    private final String [] columnNames;
    private final Object[][] data;

    public ASCTableModel(String[] colNames, ArrayList<ASCStockItem> storedData) {
        int columnNamesLength = colNames.length;
        
        //copy parameter array into column names
        columnNames = Arrays.copyOf(colNames, columnNamesLength);
        //get size of arraylist
        int rowLength = storedData.size();
        
        //set size of data array
        data = new Object[rowLength][columnNamesLength];
        
        //set index variables for data row
        int row=0;
        
        //loop through array list
        for (ASCStockItem item: storedData){
            //get fields
            String productCode = item.itemCode();
            String title = item.itemTitle();
            String description = item.itemDescription();
            Double price = item.priceInPounds() + (item.priceInPence()/100.0);
            Integer quantity = item.stockQuantity();
        
            //use fields to create object array
            Object [] dataRow = new Object[] {productCode, title, description, "£" + price, quantity};
            
            //copy row data array into current data row
            data[row] = Arrays.copyOf(dataRow, columnNamesLength);
            
            //increase row index
            row++;
        }
        
    }
    
    

    @Override
    public int getRowCount() {
       return data.length; 
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}
    
