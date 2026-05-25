package SS15_Bai1.service;

import SS15_Bai1.model.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieManager<T extends Movie> {
    private final List<T> movieList = new ArrayList<>();

    public void addMovie(T movie) {
        movieList.add(movie);
        System.out.println("Thêm phim thành công!");
    }

    public boolean updateMovie(String id, String newTitle, String newDirector, java.time.LocalDate newReleaseDate, double newRating) {
        for (T movie : movieList) {
            if (movie.getId().equals(id)) {
                movie.setTitle(newTitle);
                movie.setDirector(newDirector);
                movie.setReleaseDate(newReleaseDate);
                movie.setRating(newRating);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMovie(String id) {
        return movieList.removeIf(movie -> movie.getId().equals(id));
    }

    public void displayAll() {
        if (movieList.isEmpty()) {
            System.out.println("Danh sách phim trống.");
            return;
        }
        for (T movie : movieList) {
            System.out.println(movie);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (T movie : movieList) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(movie);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy phim");
        }
    }

    public void filterHighRating() {
        boolean found = false;
        for (T movie : movieList) {
            if (movie.getRating() > 8.0) {
                System.out.println(movie);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có phim nào có rating > 8.0");
        }
    }
}