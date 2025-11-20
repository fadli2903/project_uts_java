import java.util.ArrayList;
import java.util.List;

public class PropertyManager {
    private final ArrayList<Properti> daftarProperti = new ArrayList<>();
    private final ArrayList<Penyewa> daftarPenyewa = new ArrayList<>();

    public void tambahProperti(Properti p) {
        daftarProperti.add(p);
    }

    public void tampilkanSemuaProperti() {
        if (daftarProperti.isEmpty()) {
            System.out.println("Belum ada properti terdaftar.");
            return;
        }
        for (Properti p : daftarProperti) {
           if (p instanceof KamarKos) {
    ((KamarKos)p).tampilkanDetail();
          } else if (p instanceof Kontrakan) {
    ((Kontrakan)p).tampilkanDetail();
        } else {
    p.tampilkanInfo();
     }
        }
    }
public void cariProperti(String id) {
    for (Properti p : daftarProperti) {
        if (p.getId().equalsIgnoreCase(id)) {
            System.out.println("Properti ditemukan:");
            System.out.println(p);
            return;
        }
    }
    System.out.println("Properti tidak ditemukan!");
}

    public Properti cariPropertiById(String id) {
        for (Properti p : daftarProperti) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean updateHarga(String id, double hargaBaru) {
        Properti p = cariPropertiById(id);
        if (p != null) {
            p.setHargaPerBulan(hargaBaru);
            return true;
        }
        return false;
    }

    public boolean tambahPenyewa(Penyewa penyewa) {
        KamarKos kamar = penyewa.getKamar();
        if (kamar != null && kamar.isTersedia()) {
            kamar.ubahStatus(false);
            daftarPenyewa.add(penyewa);
            return true;
        }
        return false;
    }

    public void tampilkanSemuaPenyewa() {
        if (daftarPenyewa.isEmpty()) {
            System.out.println("Belum ada penyewa terdaftar.");
            return;
        }
        for (Penyewa py : daftarPenyewa) {
            py.tampilkanInfo();
        }
    }

    public Penyewa cariPenyewaById(String id) {
        for (Penyewa py : daftarPenyewa) {
            if (py.getIdPenyewa().equalsIgnoreCase(id)) return py;
        }
        return null;
    }

    public boolean hapusPenyewa(String idPenyewa) {
        Penyewa py = cariPenyewaById(idPenyewa);
        if (py != null) {
            KamarKos kamar = py.getKamar();
            if (kamar != null) kamar.ubahStatus(true);
            daftarPenyewa.remove(py);
            return true;
        }
        return false;
    }

    public void cekStatusProperti(String id) {
        Properti p = cariPropertiById(id);
        if (p == null) {
            System.out.println("Properti tidak ditemukan.");
            return;
        }
        System.out.printf("Status %s: %s\n", id, p.isTersedia() ? "Tersedia" : "Tidak tersedia");
    }
}
