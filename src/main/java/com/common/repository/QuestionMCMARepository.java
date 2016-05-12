package com.common.repository;

import com.common.model.QuestionMultCMultA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//multiple choice - multiple answer
@Repository
@Transactional
public interface QuestionMCMARepository extends JpaRepository<QuestionMultCMultA,Integer> {


}
