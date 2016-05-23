package com.common.repository;

import com.common.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {

    List<Interview> findByCreator_IdUser(int idUser);

}
