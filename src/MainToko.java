import java.util.*;

public class MainToko {

    static class Barang {
        private int id, stock, harga;
        private String nama;

        public Barang(int id, String nama, int stock, int harga) {
            this.id = id; this.nama = nama; this.stock = stock; this.harga = harga;
        }
        public int getId() { return id; }
        public int getStock() { return stock; }
        public int getHarga() { return harga; }
        public String getNama() { return nama; }
        public void minusStock(int qty) { if (qty > 0 && qty <= stock) stock -= qty; }
    }

    static class Order {
        private int id, jumlah;
        private Barang barang;

        public Order(int id, Barang barang, int jumlah) {
            this.id = id; this.barang = barang; this.jumlah = jumlah;
        }
        public int getId() { return id; }
        public int getJumlah() { return jumlah; }
        public Barang getBarang() { return barang; }
        public int getTotal() { return barang.getHarga() * jumlah; }
    }

    static final Scanner in = new Scanner(System.in);
    static final List<Barang> barangList = new ArrayList<>();
    static final List<Order> pesanan = new ArrayList<>();

    public static void main(String[] args) {
        seedData();
        while (true) {
            menuAwal();
            String pilih = in.nextLine().trim();
            switch (pilih) {
                case "1": menuPesanBarang(); break;
                case "2": menuLihatPesanan(); break;
                default:  return;
            }
        }
    }

    static void seedData() {
        barangList.add(new Barang(1, "Pulpen Easy Gel 0.5mm", 120, 2000));
        barangList.add(new Barang(2, "Penggaris 30cm", 20, 5000));
        barangList.add(new Barang(3, "Tipe-x Roller", 30, 7000));
        barangList.add(new Barang(4, "Pensil Mekanik", 50, 5000));
        barangList.add(new Barang(5, "Buku Tulis", 100, 6000));
    }

    static void garis() {
        System.out.println("----------------------------------------");
    }

    static void menuAwal() {
        System.out.println();
        System.out.println("Menu Awal Program");
        System.out.println("|-----------Menu Toko Multiguna-----------");
        System.out.println("1. Pesan Barang");
        System.out.println("2. Lihat Pesanan");
        System.out.print("Pilihan : ");
    }

    static void tampilkanDaftarBarang() {
        System.out.println();
        System.out.println("Daftar Barang Toko Multiguna");
        for (Barang b : barangList) {
            System.out.println("ID    : " + b.getId());
            System.out.println("Nama  : " + b.getNama());
            System.out.println("Stock : " + b.getStock());
            System.out.println("Harga : " + b.getHarga());
            garis();
        }
        System.out.println("Ketik 0 untuk batal");
    }

    static void menuPesanBarang() {
        tampilkanDaftarBarang();
        System.out.print("Pesan Barang (ID) : ");
        String sId = in.nextLine().trim();
        if (!sId.matches("\\d+")) { System.out.println("ID Barang Tidak Sesuai Pilihan"); return; }
        int id = Integer.parseInt(sId);
        if (id == 0) return;

        Barang dipilih = null;
        for (Barang b : barangList) if (b.getId() == id) { dipilih = b; break; }
        if (dipilih == null) { System.out.println("ID Barang Tidak Sesuai Pilihan"); return; }

        System.out.print("Masukkan Jumlah : ");
        String sQty = in.nextLine().trim();
        if (!sQty.matches("\\d+")) { System.out.println("Jumlah Barang Tidak Sesuai Stock"); return; }
        int qty = Integer.parseInt(sQty);
        if (qty <= 0 || qty > dipilih.getStock()) {
            System.out.println("Jumlah Barang Tidak Sesuai Stock"); return;
        }

        int total = dipilih.getHarga() * qty;
        System.out.println(qty + " @ " + dipilih.getNama() + " dengan total harga " + total);

        System.out.print("Masukkan jumlah uang : ");
        String sPay = in.nextLine().trim();
        if (!sPay.matches("\\d+")) { System.out.println("Jumlah Uang Tidak Mencukupi"); return; }
        int bayar = Integer.parseInt(sPay);
        if (bayar < total) { System.out.println("Jumlah Uang Tidak Mencukupi"); return; }

        dipilih.minusStock(qty);
        pesanan.add(new Order(pesanan.size() + 1, dipilih, qty));
        System.out.println("Berhasil dipesan");
    }

    static void menuLihatPesanan() {
        System.out.println();
        System.out.println("Daftar Pesanan Toko Multiguna");
        if (pesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }
        for (Order o : pesanan) {
            System.out.println("ID     : " + o.getId());
            System.out.println("Nama   : " + o.getBarang().getNama());
            System.out.println("Jumlah : " + o.getJumlah());
            System.out.println("Total  : " + o.getTotal());
            garis();
        }
        System.out.print("Tekan Enter untuk kembali...");
        in.nextLine();
    }
}
