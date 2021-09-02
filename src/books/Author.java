package books;

import java.util.Objects;

public class Author {

    String authorName;

    public Author(String authorName) {

        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        //System.out.println("Comparing '" + this.genreName + "' with '" + genre.getGenreName() + "'");
        return authorName.equals(author.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName);
    }

    @Override
    public String toString() {
        return getAuthorName();
    }
}
