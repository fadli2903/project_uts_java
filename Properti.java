public class Properti {
    private String id;
    private String alamat;
    private double hargaPerBulan;
    private boolean tersedia;

    public Properti(String id, String alamat, double hargaPerBulan, boolean tersedia) {
        this.id = id;
        this.alamat = alamat;
        this.hargaPerBulan = hargaPerBulan;
        this.tersedia = tersedia;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public double getHargaPerBulan() { return hargaPerBulan; }
    public void setHargaPerBulan(double hargaPerBulan) { this.hargaPerBulan = hargaPerBulan; }

    public boolean isTersedia() { return tersedia; }
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }

    public void tampilkanInfo() {
        System.out.printf("ID: %s | Alamat: %s | Harga/bln: %.0f | Tersedia: %s\n",
                id, alamat, hargaPerBulan, tersedia ? "Ya" : "Tidak");
    }

    public void ubahStatus(boolean statusBaru) {
        this.tersedia = statusBaru;
    }
}
