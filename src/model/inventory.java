package model;

public class inventory {
    int id;
    String nama;
    String kategori;
    int stok;

    // Konstruktor yang sesuai
    public inventory(int id, String nama, String kategori, int stok) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.stok = stok;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
