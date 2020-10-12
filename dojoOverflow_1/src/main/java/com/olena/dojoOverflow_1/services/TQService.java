package com.olena.dojoOverflow_1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.olena.dojoOverflow_1.models.Answer;
import com.olena.dojoOverflow_1.models.Question;
import com.olena.dojoOverflow_1.models.Tag;
import com.olena.dojoOverflow_1.repositories.AnswerRepository;
import com.olena.dojoOverflow_1.repositories.QuestionRepository;
import com.olena.dojoOverflow_1.repositories.TagRepository;

@Service
public class TQService {
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	private final TagRepository tagRepository;
	public TQService(AnswerRepository aR, QuestionRepository qR, TagRepository tR) {
		this.answerRepository = aR;
		this.questionRepository = qR;
		this.tagRepository = tR;
	}
	
	 public List<Answer> allAnswers() {
		 return answerRepository.findAll();
	 }
	 
	 public List<Question> allQuestions() {
		 return questionRepository.findAll();
	 }

	 public List<Tag> allTags() {
		 return tagRepository.findAll();
	 }
	 
	public Answer createAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	public Tag createTag(Tag tag) {
		return tagRepository.save(tag);
	}
	 public Tag findTag(Long id) {
		 return tagRepository.findById(id).orElse(null);
	 }
}
