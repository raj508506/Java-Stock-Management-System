package oop.ica.e2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kusuma
 * 
 */
public  class ASCStockItem {
    
    private String itemCode;
    private String itemTitle;
    private  String itemDescription;
    private int priceInPounds;
    private int priceInPence;
    private int stockQuantity;
// methods to display the asc stock items details
    public  ASCStockItem (String productCode, String productTitle, String productDescription, int pricePounds, int pricePence, int stockQuantity) {
        this.itemCode = productCode;
        this.itemTitle = productTitle;
        this.itemDescription = productDescription;
        this.priceInPounds = pricePounds;
        this.priceInPence = pricePence;
        this.stockQuantity = stockQuantity;
    }
    
    public String itemCode() {
        return itemCode;
    }

    public String itemTitle() {
        return itemTitle;
    }

    public String itemDescription() {
        return itemDescription;
    }

    public int priceInPounds() {
        return priceInPounds;
    }

    public int priceInPence() {
        return priceInPence;
    }

    public int stockQuantity() {
        return stockQuantity;
    }
    
    public double itemPrice(){
        return (priceInPounds + (priceInPence/100.0));
    }
    
    public void setQuantity(int stockQuantity){
        this.stockQuantity = stockQuantity;
    }
}
