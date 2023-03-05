package com.codingdojo.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller
public class HomeController {

	@Autowired
	AnswerService answerService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	TagService tagService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", questionService.allQuestions());
		return "dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result, @RequestParam("questionTags") String tags, Model model) {
		List<Tag> potentialTags = tagService.checkTags(tags, result);
		System.out.println(potentialTags);
		if (result.hasErrors()) {
			model.addAttribute("questionTags", tags);
			return "newQuestion.jsp";
		}
		
		question.setTags(potentialTags);
		questionService.createQuestion(question);
		return "redirect:/";
	}
	
	@GetMapping("/questions/{questionId}")
	public String showQuestion(@PathVariable("questionId") Long questionId, Model model, @ModelAttribute("answer") Answer answer) {
		model.addAttribute("question", questionService.findQuestion(questionId));
		return "showQuestion.jsp";
	}
	
	@PostMapping("/questions/{questionId}")
	public String addAnswertoQuestion(@PathVariable("questionId") Long questionId, @Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("question", questionService.findQuestion(questionId));
			return "showQuestion.jsp";
		}
		answer.setQuestion(questionService.findQuestion(questionId));
		answerService.createAnswer(answer);
		
		return "redirect:/questions/" + questionId;
	}
}
