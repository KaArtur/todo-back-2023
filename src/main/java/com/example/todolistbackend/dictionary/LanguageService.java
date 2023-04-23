package com.example.todolistbackend.dictionary;

import com.example.todolistbackend.todo.ToDo;
import com.example.todolistbackend.todo.ToDoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository repository;

    public List<Language> list() {
        return repository.findAll();
    }

    public Long count() {
        return repository.count();
    }

    public Language get(Integer id) {
        return repository.findById(id).get();
    }

    public Language create(String name, String code) {
        Language language = new Language();
        language.setName(name);
        language.setCode(code);
        return repository.save(language);
    }

    public Language update(Language request) {
        Language language = repository.findById(request.getId()).orElseThrow();
        language.setCode(request.getCode());
        language.setName(request.getName());
        return repository.save(language);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
