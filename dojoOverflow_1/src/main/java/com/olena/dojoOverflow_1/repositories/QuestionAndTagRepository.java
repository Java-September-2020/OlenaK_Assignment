package com.olena.dojoOverflow_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olena.dojoOverflow_1.models.QuestionAndTag;

@Repository
public interface QuestionAndTagRepository extends JpaRepository<QuestionAndTag, Long> {

}
