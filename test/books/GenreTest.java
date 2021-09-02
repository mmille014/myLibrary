package books;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenreTest {
    @Test
    void testHashing() {
        Set<Genre> testSet = new HashSet<>();
        final Genre genre_1 = new Genre("Christian Fiction");
        final Genre genre_2 = new Genre("Christian Fiction");
        testSet.add(genre_1);
        testSet.add(genre_2);
        assertEquals(1, testSet.size());
        testSet.add(new Genre("Science Fiction"));
        assertEquals(2, testSet.size());
    }

    @Test
    void testRecall() {
        Map<Genre, Integer> valueOfGenre = new HashMap<>();
        final String christian_fiction = "Christian Fiction";
        final Genre genre_1 = new Genre(christian_fiction);
        valueOfGenre.put(genre_1, 10000);
        final String computer_science_textbook = "Computer Science Textbook";
        genre_1.setGenreName(computer_science_textbook); // DON'T ALLOW THIS!!!!
        // assertEquals(10000, valueOfGenre.get(genre_1), "Could not find with the key itself");
        final Genre compSci = new Genre(computer_science_textbook);
        // assertEquals(10000, valueOfGenre.get(compSci), "Could not find with comp-sci");
        final Genre chrFiction = new Genre(christian_fiction);
        assertEquals(10000, valueOfGenre.get(chrFiction), "Could not find with chrFiction");
    }

    @Test
    void testToString() {
        final Genre test_subject = new Genre("genre name");
        assertEquals("genre name", test_subject.toString());

    }
}
