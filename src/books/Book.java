package books;

public class Book {
    private String title;
    private Author author;
    private Genre genre;
    private String overview;
    private String image;

    public Book() {

    }

    public Book(String title, Author author, Genre genre, String overview, String image) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.overview = overview;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
