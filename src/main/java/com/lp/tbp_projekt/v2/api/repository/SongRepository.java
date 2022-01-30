package com.lp.tbp_projekt.v2.api.repository;

import com.lp.tbp_projekt.v2.api.models.Song;
import com.lp.tbp_projekt.v2.api.models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface SongRepository extends Neo4jRepository<Song, String>
{
    @Query("MATCH (user:User{id: $userId})-[:RATED]->(song) " +
            "WITH song " +
            "MATCH (song)-[o:ON_ALBUM]->(album), " +
            "(song)-[g:IN_GENRE]->(genre), " +
            "(song)-[s:IN_SUBGENRES]->(subgenre), " +
            "(album)-[a:BY_ARTIST]->(artist)" +
            "RETURN song, collect(o), album, collect(g), genre, collect(s), subgenre, collect(a), artist")
    List<Song> findSongsRatedByUser(String userId);
}
