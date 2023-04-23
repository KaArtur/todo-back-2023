package com.example.todolistbackend.dictionary;

import com.example.todolistbackend.todo.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public List<Language> list() {
        return languageService.list();
    }

    @GetMapping ("/property/count")
    public Long count() {
        return languageService.count();
    }

    @GetMapping("/{id}")
    public Language get(@PathVariable Integer id) {
        return languageService.get(id);
    }

    @PostMapping
    public Language create(@RequestBody Language language) {
        return languageService.create(language.getCode(), language.getName());
    }

    @PutMapping
    public Language update(@RequestBody Language request) {
        return languageService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
         languageService.delete(id);
    }

}
