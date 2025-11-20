public class Kontrakan extends Properti {
    private int jumlahKamar;
    private boolean autoGarasi;
    private String tipeKontrak;

    public Kontrakan(String id, String alamat, double hargaPerBulan, boolean tersedia,
                     int jumlahKamar, boolean autoGarasi, String tipeKontrak) {
        super(id, alamat, hargaPerBulan, tersedia);
        this.jumlahKamar = jumlahKamar;
        this.autoGarasi = autoGarasi;
        this.tipeKontrak = tipeKontrak;
    }

    public int getJumlahKamar() { return jumlahKamar; }
    public void setJumlahKamar(int jumlahKamar) { this.jumlahKamar = jumlahKamar; }

    public boolean hasGarasi() { return autoGarasi; }
    public void setAutoGarasi(boolean autoGarasi) { this.autoGarasi = autoGarasi; }

    public String getTipeKontrak() { return tipeKontrak; }
    public void setTipeKontrak(String tipeKontrak) { this.tipeKontrak = tipeKontrak; }

    public void tampilkanDetail() {
        tampilkanInfo();
        System.out.printf("   [Kontrakan] Kamar: %d | Garasi: %s | Tipe: %s\n",
                jumlahKamar, autoGarasi ? "Ada" : "Tidak", tipeKontrak);
    }

    public void ubahTipeKontrak(String tipeBaru) {
        this.tipeKontrak = tipeBaru;
    }
}
