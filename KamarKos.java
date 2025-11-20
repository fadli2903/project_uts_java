public class KamarKos extends Properti {
    private double luas;
    private int nomorKamar;
    private String fasilitas;

    public KamarKos(String id, String alamat, double hargaPerBulan, boolean tersedia,
                    double luas, int nomorKamar, String fasilitas) {
        super(id, alamat, hargaPerBulan, tersedia);
        this.luas = luas;
        this.nomorKamar = nomorKamar;
        this.fasilitas = fasilitas;
    }

    public double getLuas() { return luas; }
    public void setLuas(double luas) { this.luas = luas; }

    public int getNomorKamar() { return nomorKamar; }
    public void setNomorKamar(int nomorKamar) { this.nomorKamar = nomorKamar; }

    public String getFasilitas() { return fasilitas; }
    public void setFasilitas(String fasilitas) { this.fasilitas = fasilitas; }

    public void tampilkanDetail() {
        tampilkanInfo();
        System.out.printf("   [KamarKos] No: %d | Luas: %.1fm2 | Fasilitas: %s\n",
                nomorKamar, luas, fasilitas);
    }

    public void tambahFasilitas(String tambahan) {
        this.fasilitas = this.fasilitas + ", " + tambahan;
    }
}
