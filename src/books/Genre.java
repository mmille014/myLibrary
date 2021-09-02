package books;

import java.util.Objects;

public class Genre {

    String genreName;

    public Genre(String genreName) {

        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        //System.out.println("Comparing '" + this.genreName + "' with '" + genre.getGenreName() + "'");
        return genreName.equals(genre.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreName);
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("<")
//                .append("Genre: [")
//                .append("genreName='")
//                .append(getGenreName())
//                .append("'")
//                .append("]>");
//        return sb.toString();
        return getGenreName();
    }

}

