package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository answerRepository;

	public List<Answer> allAnswers() {
		return answerRepository.findAll();
	}
	
	public List<Answer> answersForQuestion(Question q) {
		return answerRepository.findByQuestion(q);
	}
	
	public Answer createAnswer(Answer a) {
		return answerRepository.save(a);
	}
}
