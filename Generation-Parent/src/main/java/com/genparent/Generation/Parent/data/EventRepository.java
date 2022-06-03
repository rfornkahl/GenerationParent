package com.genparent.Generation.Parent.data;

import com.genparent.Generation.Parent.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

}
