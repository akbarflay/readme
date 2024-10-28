package modul2.tugas.sesudahrefactor;
class Buku {
    private String title; // rename variabel
    private String author;
    private int publicationYear;

    public Buku(String judul) {
        this.title = judul;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return String.format("%s (%s, %d)", title, author, publicationYear);
    }
}