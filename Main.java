import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        PropertyManager manager = new PropertyManager();

        manager.tambahProperti(new KamarKos("A01", "Jl. Kenanga 10", 500000, true, 12.5, 101, "Kasur, Lemari, Kipas"));
        manager.tambahProperti(new Kontrakan("B01", "Jl. Melati 3", 2500000, true, 3, true, "Tahunan"));
        manager.tambahProperti(new KamarKos("C02", "Jl. Mawar 5", 600000, false, 15.0, 102, "Kasur, Meja, AC"));
        manager.tambahProperti(new Kontrakan("D02", "Jl. Anggrek 7", 2000000, true, 2, false, "Bulanan"));
        manager.tambahProperti(new KamarKos("E03", "Jl. Dahlia 2", 550000, true, 10.0, 103, "Kasur, Lemari, TV"));

        boolean running = true;
        while (running) {
            System.out.println("\n=== SISTEM PENGELOLAAN KOS & KONTRAKAN ===");
            System.out.println("1. Tambah properti");
            System.out.println("2. Tampilkan semua properti");
            System.out.println("3. Cari properti");
            System.out.println("4. Ubah harga");
            System.out.println("5. Tambah penyewa");
            System.out.println("6. Tampilkan penyewa");
            System.out.println("7. Cek status properti");
            System.out.println("8. Hapus penyewa");
            System.out.println("9. Keluar");
            System.out.print("Pilih: ");
            String pilih = sc.nextLine();

           
            switch (pilih) {
                case "1" -> {
                    System.out.print("Jenis (1=KamarKos, 2=Kontrakan): ");
                    String jenis = sc.nextLine();

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Alamat: ");
                    String alamat = sc.nextLine();

                    System.out.print("Harga: ");
                    double harga = Double.parseDouble(sc.nextLine());

                    if (jenis.equals("1")) {
                        System.out.print("Tersedia (true/false): ");
                        boolean tersedia = Boolean.parseBoolean(sc.nextLine());

                        System.out.print("Luas (m2): ");
                        double luas = Double.parseDouble(sc.nextLine());

                        System.out.print("Nomor kamar: ");
                        int noKamar = Integer.parseInt(sc.nextLine());

                        System.out.print("Fasilitas: ");
                        String fasilitas = sc.nextLine();

                        manager.tambahProperti(new KamarKos(id, alamat, harga, tersedia, luas, noKamar, fasilitas));
                    } else {
                        System.out.print("Jumlah kamar: ");
                        int jumlahKamar = Integer.parseInt(sc.nextLine());

                        System.out.print("Ada Garasi? (true/false): ");
                        boolean garasi = Boolean.parseBoolean(sc.nextLine());

                        System.out.print("Tipe Kontrak (Bulanan/Tahunan): ");
                        String tipe = sc.nextLine();

                        manager.tambahProperti(new Kontrakan(id, alamat, harga, true, jumlahKamar, garasi, tipe));
                    }

                    System.out.println("Properti berhasil ditambahkan!");
                }

                case "2" -> manager.tampilkanSemuaProperti();

                case "3" -> {
                    System.out.print("Masukkan ID properti yang dicari: ");
                    String idCari = sc.nextLine();
                    manager.cariProperti(idCari);
                }

                case "4" -> {
                    System.out.print("Masukkan ID properti: ");
                    String idHarga = sc.nextLine();

                    System.out.print("Harga baru: ");
                    double hargaBaru = Double.parseDouble(sc.nextLine());

                    manager.updateHarga(idHarga, hargaBaru);
                }

                case "5" -> {
                    System.out.print("ID Penyewa: ");
                    String idP = sc.nextLine();

                    System.out.print("Nama Penyewa: ");
                    String namaP = sc.nextLine();

                    System.out.print("No Telepon: ");
                    String telp = sc.nextLine();

                    System.out.print("ID Kamar yang disewa: ");
                    String idSewa = sc.nextLine();

                    manager.tambahPenyewa(new Penyewa(idP, namaP, telp, KamarKos.class.cast(manager.cariPropertiById(idSewa))));
                }

                case "6" -> manager.tampilkanSemuaPenyewa();

                case "7" -> {
                    System.out.print("Masukkan ID properti: ");
                    String idStatus = sc.nextLine();
                    manager.cekStatusProperti(idStatus);
                }

                case "8" -> {
                    System.out.print("Masukkan ID penyewa yang akan dihapus: ");
                    String idHapus = sc.nextLine();
                    manager.hapusPenyewa(idHapus);
                }

                case "9" -> {
                    running = false;
                    System.out.println("Program selesai.");
                }

                default -> System.out.println("Pilihan tidak tersedia!");
            }
        }

        sc.close();
    }
}
