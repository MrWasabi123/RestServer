package msp.services;

import java.util.List;

import msp.model.Lecture;

public interface LectureService {

	List<Lecture> findAllLectures();

	List<Lecture> findById(long id);

	List<Lecture> findAllBySearchQuerry(String searchQuerry);

}
