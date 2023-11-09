import java.util.List;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class MovieKafkaGenerator
{
    private final List<Movie> movies = List.of(
        new Movie(1, "The Hobbit", "Peter Jackson", "Fantasy"),
        new Movie(2, "Star Trek: First Contact", "Jonathan Frakes", "Space"),
        new Movie(3, "Encanto", "Jared Bush", "Animation"),
        new Movie(4, "Cruella", "Craig Gillespie", "Crime Comedy"),
        new Movie(5, "Sing 2", "Garth Jennings", "Jukebox Musical Comedy")
    );

    @Outgoing("movies")
    public Multi<Record<Integer, Movie>> movies()
    {
        return Multi.createFrom().items(movies.stream()
            .map(movie -> Record.of(movie.id(), movie)));
    }
}
