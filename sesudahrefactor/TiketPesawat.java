package modul2.tugas.sesudahrefactor;

public class TiketPesawat extends Pemesanan implements Tiket {
    private double hargaTiket;
    private double diskon;

    public TiketPesawat(TiketInfo info) {
        super(info.nama, info.asal, info.tujuan);
        this.hargaTiket = info.hargaTiket;
        this.diskon = info.diskon;
    }

    @Override
    public double hitungBiayaTiket() {
        return hargaTiket - hitungDiskon();
    }

    @Override
    public double hitungDiskon() {
        return hargaTiket * (diskon / 100);
    }

    @Override
    public void tampilkanInformasi() {
        System.out.println("Nama Penumpang: " + nama);
        System.out.println("Asal: " + asal);
        System.out.println("Tujuan: " + tujuan);
        System.out.println("Harga Tiket: " + hargaTiket);
        System.out.println("Diskon: " + diskon + "%");
        System.out.println("Biaya Tiket Setelah Diskon: " + hitungBiayaTiket());
        System.out.println("Jumlah Diskon: " + hitungDiskon());
    }
}
