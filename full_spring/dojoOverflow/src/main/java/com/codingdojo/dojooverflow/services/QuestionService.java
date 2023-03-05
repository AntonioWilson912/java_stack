package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	public List<Question> allQuestions() {
		return questionRepository.findAll();
	}
	
	public Question findQuestion(Long id) {
		Optional<Question> question = questionRepository.findById(id);
		if (question.isPresent()) {
			return question.get();
		}
		
		return null;
	}
	
	public List<Question> findQuestionsWithTag(Tag t) {
		return questionRepository.findByTags(t);
	}
	
	public Question createQuestion(Question q) {
		return questionRepository.save(q);
	}

}
