package com.lp.tbp_projekt.v2.api.repository;

import com.lp.tbp_projekt.v2.api.models.Recommendation;
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

    @Query("MATCH (user:User{id: $userId})-[r:RATED]->(song) WHERE song.id=$songId RETURN r.rating")
    Integer getSongRatingByUser(String userId, String songId);

    @Query("MATCH (song:Song) WHERE NOT (song)-[:RATED]-(:User{id: $userId}) " +
            "WITH song " +
            "MATCH (song)-[o:ON_ALBUM]->(album), " +
            "(song)-[g:IN_GENRE]->(genre), " +
            "(song)-[s:IN_SUBGENRES]->(subgenre), " +
            "(album)-[a:BY_ARTIST]->(artist) " +
            "RETURN song, collect(o), album, collect(g), genre, collect(s), subgenre, collect(a), artist " +
            "ORDER BY rand() LIMIT 1")
    Song findUnratedSongsForUser(String userId);

    @Query("MATCH (user1:User{id: $userId})-[r1:RATED]->(song:Song) WITH user1, avg(r1.rating) AS user1Avg " +
            "MATCH (user1)-[r1:RATED]->(song:Song)<-[r2:RATED]-(user2) WITH user1, user1Avg, user2, COLLECT({r1: r1, r2: r2}) AS ratings " +
            "MATCH (user2)-[r:RATED]->(song:Song) WITH user1, user1Avg, user2, avg(r.rating) AS user2Avg, ratings " +
            "UNWIND ratings AS r " +
            "WITH sum((r.r1.rating-user1Avg) * (r.r2.rating-user2Avg)) AS numerator, sqrt( sum( (r.r1.rating - user1Avg)^2) * sum( (r.r2.rating - user2Avg)^2)) AS denominator, user1, user2 WHERE denominator <> 0 " +
            "WITH user1, user2, numerator/denominator AS pearson ORDER BY pearson DESC LIMIT 10 " +
            "MATCH (user2)-[r:RATED]->(song:Song) WHERE NOT EXISTS( (user1)-[:RATED]->(song)) " +
            "MATCH (song)-[o:ON_ALBUM]->(album), " +
            "(song)-[g:IN_GENRE]->(genre), " +
            "(song)-[s:IN_SUBGENRES]->(subgenre), " +
            "(album)-[a:BY_ARTIST]->(artist) " +
            "RETURN song, SUM( pearson * r.rating) AS score, collect(o), album, collect(g), genre, collect(s), subgenre, collect(a), artist " +
            "ORDER BY score DESC LIMIT 25"
    )
    List<Recommendation> getRecommendationForUser(String userId);
}
