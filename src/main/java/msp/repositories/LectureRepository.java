package msp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import msp.model.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

}

