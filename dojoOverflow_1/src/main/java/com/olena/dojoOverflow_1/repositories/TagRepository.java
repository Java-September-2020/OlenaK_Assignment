package com.olena.dojoOverflow_1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olena.dojoOverflow_1.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
	List<Tag>findAll();
}
