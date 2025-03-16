/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

/**
 *
 * @author Ihsan
 */
public class Item {

    private int no;
    private String nama;
    private String kategori;
    private int stock;
    
    public Item(int no, String nama, String kategori, int stock) {
        this.no = no;
        this.nama = nama;
        this.kategori = kategori;
        this.stock = stock;
    }
    public int getNo() { return no; }
    public String getName() { return nama; }
    public String getCategory() { return kategori; }
    public int getQuantity() { return stock; }

    @Override
    public String toString() {
        return no + ". " + nama + " (" + kategori + ") - " + stock;
    }
    }
