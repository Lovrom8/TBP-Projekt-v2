package com.lp.tbp_projekt.v2.api.repository;

import com.lp.tbp_projekt.v2.api.models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends Neo4jRepository<User, String>
{
    @Query("MATCH (user:User) WHERE user.email = $email RETURN user")
    User findUserByEmail(String email);

    @Query("{'_id':?0}")
    User findUserById(String id);
}
