package modul2.tugas.sesudahrefactor;

public abstract class Pemesanan {
    protected String nama;
    protected String asal;
    protected String tujuan;

    public Pemesanan(String nama, String asal, String tujuan) {
        this.nama = nama;
        this.asal = asal;
        this.tujuan = tujuan;
    }

    public abstract void tampilkanInformasi();
}
