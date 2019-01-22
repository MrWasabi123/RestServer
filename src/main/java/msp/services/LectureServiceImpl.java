package msp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import msp.model.Lecture;
import msp.repositories.LectureRepository;

@Service
public class LectureServiceImpl implements LectureService{
	
	private LectureRepository lectureRepository;
	
	public LectureServiceImpl(LectureRepository lectureRepository) {
		this.lectureRepository = lectureRepository;
	}
	
	@Override
	public List<Lecture> findAllLectures(){
		return lectureRepository.findAll();
	}

}
