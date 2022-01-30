package com.lp.tbp_projekt.v2.api.repository;

import com.lp.tbp_projekt.v2.api.models.Artist;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ArtistRepository extends Neo4jRepository<Artist, String>
{
}
