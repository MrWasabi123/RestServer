package msp.services;

import java.util.ArrayList;
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

	@Override
	public List<Lecture> findById(long id) {
		List<Lecture> lectures = new ArrayList<>();
		lectures.add(lectureRepository.findById(id).get());
		return lectures;
	}

	@Override
	public List<Lecture> findAllBySearchQuerry(String searchQuerry) {
		List<Lecture> lectures = new ArrayList<>();
		for(Lecture l: lectureRepository.findAll()) {
			String search = searchQuerry.toLowerCase();
			String lectureName = l.getName().toLowerCase();
			if(lectureName.contains(search)) {
				lectures.add(l);
			}
		}
		return lectures;
	}

}
