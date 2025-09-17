public class MataKuliah {
    private String Kode;
    private String nama;
    private int sks;

    public MataKuliah(){}
    public MataKuliah(String Kode, String nama, int sks) {
        this.Kode = Kode;
        this.nama = nama;
        this.sks = sks;
    }
    public String getKode() {
        return Kode;
    }
    public void setKode(String Kode) {
        this.Kode = Kode;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getSks() {
        return sks;
    }
    public void setSks(int sks) {
        this.sks = sks;
    }
}
