package com.codingdojo.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	
	@Autowired
	TagRepository tagRepository;

	public List<Tag> allTags() {
		return tagRepository.findAll();
	}
	
	public Tag createTag(Tag t) {
		return tagRepository.save(t);
	}
	
	public Tag findTag(Long id) {
		Optional<Tag> tag = tagRepository.findById(id);
		if (tag.isPresent()) {
			return tag.get();
		}
		
		return null;
	}
	
	public Tag findTagBySubject(String subject) {
		return tagRepository.findBySubject(subject);
	}
	
	public List<Tag> findTagsByQuestion(Question q) {
		return tagRepository.findByQuestions(q);
	}
	
	public ArrayList<Tag> checkTags(String tags, BindingResult result) {
		ArrayList<Tag> potentialTags = new ArrayList<Tag>();
		String[] subjects;
		Tag tempTag;
		
		if (tags.length() == 0) {
			result.rejectValue("tags", "None", "At least one tag must be present!");
		}
		else {
			// Remove all leading and trailing whitespace and remove space after comma if necessary
			tags = tags.strip().replace(", ", ",").toLowerCase();
			subjects = tags.split(",");
			for (String subject : subjects) {
				// Try to find the tag
				tempTag = findTagBySubject(subject);
				
				// If it doesn't exist, create it
				if (tempTag == null) {
					tempTag = new Tag();
					tempTag.setSubject(subject);
					createTag(tempTag);
				}
				potentialTags.add(tempTag);
			}
			if (potentialTags.size() > 3) {
				result.rejectValue("tags",  "Max", "Maximum of three tags per question!");
			}
		}
		
		return potentialTags;
	}
}
