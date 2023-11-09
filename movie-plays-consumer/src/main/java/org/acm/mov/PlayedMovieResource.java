package org.acm.mov;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/movies")
public class PlayedMovieResource
{
    @Channel("played-movies")
    Multi<MoviePlayed> playedMovies;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<MoviePlayed> stream()
    {
        return playedMovies;
    }

    @Incoming("movies")
    public void newMovie(Movie movie)
    {
        System.out.printf("New movie: %s", movie);
    }

}
