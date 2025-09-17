public class Barang {
    private int id;
    private int stock;
    private int harga;
    private String nama;

    public Barang(int id, String nama, int stock, int harga) {
        this.id = id;
        this.nama = nama;
        this.stock = stock;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public int getHarga() {
        return harga;
    }

    public String getNama() {
        return nama;
    }

    public void minusStock(int qty) {
        if (qty <= stock) {
            stock -= qty;
        }
    }
}
