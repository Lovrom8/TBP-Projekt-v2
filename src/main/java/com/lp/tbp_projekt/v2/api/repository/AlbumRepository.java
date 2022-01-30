package com.lp.tbp_projekt.v2.api.repository;

import com.lp.tbp_projekt.v2.api.models.Album;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AlbumRepository extends Neo4jRepository<Album, String>
{
}
