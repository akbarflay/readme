package modul2.tugas.sesudahrefactor;

public class MainTiket {
    public static void main(String[] args) {
        TiketInfo info = new TiketInfo("John Doe", "Jakarta", "Bali", 1500000, 10);
        TiketPesawat tiket = new TiketPesawat(info);

        tiket.tampilkanInformasi();
    }
}
