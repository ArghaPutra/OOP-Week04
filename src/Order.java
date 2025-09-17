public class Order {
    private int id;
    private int jumlah;
    private Barang barang;
    public static int total = 0;

    public Order() {}

    public Order(int id, Barang barang, int jumlah) {
        this.id = id;
        this.barang = barang;
        this.jumlah = jumlah;
        total += barang.getHarga() * jumlah;
    }

    public int getId() {
        return id;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Barang getBarang() {
        return barang;
    }
}
