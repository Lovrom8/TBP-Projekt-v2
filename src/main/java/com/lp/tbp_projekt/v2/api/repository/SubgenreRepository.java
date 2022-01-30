package com.lp.tbp_projekt.v2.api.repository;

import com.lp.tbp_projekt.v2.api.models.Subgenre;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SubgenreRepository extends Neo4jRepository<Subgenre, String>
{
}
