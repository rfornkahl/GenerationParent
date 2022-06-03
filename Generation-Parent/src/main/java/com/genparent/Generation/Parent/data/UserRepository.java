package com.genparent.Generation.Parent.data;

import com.genparent.Generation.Parent.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer> {
    User findByUsername(String username);
}
