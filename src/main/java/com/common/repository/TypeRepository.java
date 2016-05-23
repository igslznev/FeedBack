package com.common.repository;

import com.common.model.TypeOfQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeOfQuestion, Integer> {
}
