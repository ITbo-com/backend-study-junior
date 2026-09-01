package com.gdgku.study.backend;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;




@RestController
@RequestMapping("/movies")
public class MovieController {
    private final List<Movie> movieList = new ArrayList<>();
    private long nextId = 1L;

    public static class Movie {
        private Long id;
        private String name;

        public Movie() {}
        public Movie(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie) {
        movie.setId(nextId++);
        movieList.add(movie);
        return movie;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getAllUsers() {
        return movieList;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getUserById(@PathVariable Long id) {
        for (Movie u : movieList) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Movie putMethodName(@PathVariable Long id, @RequestBody Movie movie) {
        //TODO: process PUT request
        for (Movie u : movieList) {
            if (u.getId().equals(id)) {
                u.setName(movie.name);
                return u;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMethodName(@PathVariable Long id) {
        movieList.removeIf(movie->movie.getId().equals(id));
    }
    
}
