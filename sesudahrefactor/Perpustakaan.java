package modul2.tugas.sesudahrefactor;

import java.util.LinkedList;
import java.util.Scanner;

public class Perpustakaan {
    private LinkedList<Buku> daftarBuku = new LinkedList<>();
    private Scanner input = new Scanner(System.in);

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        Perpustakaan perpustakaan = new Perpustakaan();
        perpustakaan.run();
    }

    private void run() {
        while (true) {
            displayMenu();
            int pilihan = input.nextInt();
            input.nextLine();

            handleUserChoice(pilihan);
        }
    }

    private void displayMenu() {
        System.out.println("1. Tambah Buku");
        System.out.println("2. Tampilkan  Daftar Buku");
        System.out.println("3. Cari Buku Berdasarkan Judul");
        System.out.println("4. Keluar");
    }

    /**
     *
     * @param pilihan
     */

    private void handleUserChoice(int pilihan) { // Logika switch dipindahkan ke mode terpisah (extract method)
        switch (pilihan) {
            case 1:
                addBook();
                break;
            case 2:
                displayBookList();
                break;
            case 3:
                searchBookByTitle();
                break;
            case 4:
                System.out.println("Terima kasih telah menggunakan program ini!");
                System.exit(0);
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    private void addBook() { // setelah di refactoring menjadi getInput (extract method)
        String title = getInput("Masukkan judul buku: ");
        String author = getInput("Masukkan penulis buku: ");
        int publicationYear = getIntegerInput("Masukkan tahun terbit: ");

        Buku newBook = new Buku("title, author, publicationYear");
        daftarBuku.add(newBook);

        System.out.println("Buku berhasil ditambahkan!");
    }

    private void displayBookList() { // pemisahan logiksa untuk meningkatkan keterbacaan (extract method)
        if (daftarBuku.isEmpty()) {
            System.out.println("Daftar buku masih kosong!");
        } else {
            System.out.println("Daftar Buku:");
            daftarBuku.forEach(book -> System.out.println("- " + book));
        }
    }

    private void searchBookByTitle() { //  membuat kode lebih deklaratif (replace loop with stream)
        String searchTitle = getInput("Masukkan judul buku yang dicari: ");

        Buku foundBook = daftarBuku.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(searchTitle))
                .findFirst()
                .orElse(null);

        if (foundBook != null) {
            System.out.println("Buku ditemukan!");
            System.out.println(foundBook);
        } else {
            System.out.println("Buku tidak ditemukan!");
        }
    }

    /**
     *
     * @param prompt
     * @return
     */

    private String getInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    private int getIntegerInput(String prompt) {
        System.out.print(prompt);
        return input.nextInt();
    }
}

