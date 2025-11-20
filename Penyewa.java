public class Penyewa {
    private final String idPenyewa;
    private final String nama;
    private final String noTelp;
    private KamarKos kamar;

    public Penyewa(String idPenyewa, String nama, String noTelp, KamarKos kamar) {
        this.idPenyewa = idPenyewa;
        this.nama = nama;
        this.noTelp = noTelp;
        this.kamar = kamar;
    }

    public String getIdPenyewa() { return idPenyewa; }
    public String getNama() { return nama; }
    public String getNoTelp() { return noTelp; }
    public KamarKos getKamar() { return kamar; }
    public void setKamar(KamarKos kamar) { this.kamar = kamar; }

    public void tampilkanInfo() {
        System.out.printf("Penyewa ID: %s | Nama: %s | Telp: %s\n", idPenyewa, nama, noTelp);
        if (kamar != null) {
            System.out.print("  Menempati kamar: ");
            kamar.tampilkanDetail();
        } else {
            System.out.println("  Belum menempati kamar.");
        }
    }
}
