package org.acm.mov;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MoviePlayed
{
    public int id;
    public long duration;

    public MoviePlayed(int id, long duration) {
        this.id = id;
        this.duration = duration;
    }
}
