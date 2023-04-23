package com.example.todolistbackend.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/dictionary/entry")
public class DictionaryEntryController {

    @Autowired
    private DictionaryEntryRepository repository;

    @GetMapping
    public List<DictionaryEntry> list(){
        return repository.findAll();
    }

    @GetMapping("/property/count")
    public long count(@RequestParam(required = false) String code) {
        if (code==null) {
           return repository.count();
        }
        return repository.countByLanguageCode(code);
    }

    @GetMapping("/operation/search")
    public List<DictionaryEntry> search(@RequestParam String text) {
        return repository.findAllByWordContainingOrTranslationContainingOrDescriptionContaining(text, text, text);
    }

    @GetMapping("/{id}")
    public DictionaryEntry get(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public DictionaryEntry create(@RequestBody DictionaryEntry request) {
        DictionaryEntry dictionaryEntry = new DictionaryEntry();
        dictionaryEntry.setWord(request.getWord());
        dictionaryEntry.setTranslation(request.getTranslation());
        dictionaryEntry.setDescription(request.getDescription());
        dictionaryEntry.setLanguage(request.getLanguage());
        return repository.save(dictionaryEntry);

       /* lub
                request.setId(null);
                return repository.save(request);*/
    }

    @PutMapping
    public DictionaryEntry update(DictionaryEntry request) {
        DictionaryEntry dictionaryEntry = repository.findById(request.getId()).orElseThrow();
        dictionaryEntry.setWord(request.getWord());
        dictionaryEntry.setTranslation(request.getTranslation());
        dictionaryEntry.setDescription(request.getDescription());
        return repository.save(dictionaryEntry);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
