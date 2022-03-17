package org.adaschool.user.repository;

import org.adaschool.user.repository.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepositoryMongo
    extends MongoRepository<User, String>
{
    Optional<User> findUserByEmail( String email );
}
