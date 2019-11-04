package com.pet_project.phonebook.controller;

import com.pet_project.phonebook.entity.Record;
import com.pet_project.phonebook.entity.User;
import com.pet_project.phonebook.service.PhonebookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PhonebookController {

    private PhonebookServiceImpl phonebookService;

    @GetMapping("login")
    public String login(Map<String, Object> model) {
        return "login";
    }

    @GetMapping(value = "/")
    public String search(@RequestParam(value = "search", required = false) String searchParam, Model model) {
        List<Record> records;
        if (searchParam != null && !searchParam.isEmpty()) {
            records = phonebookService.findByLastName(searchParam);
        } else {
            records = phonebookService.getAllRecords();
        }
        model.addAttribute("search", records);
        model.addAttribute("phonebooks", records);
        return "phonebook";
    }

    @GetMapping("/add")
    public String addForm() {
        return "add";
    }

    @PostMapping("/add")
    public String addRecord(
            @AuthenticationPrincipal User user,
            @ModelAttribute Record records) {
        phonebookService.addRecord(records);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String getBuyId(@PathVariable("id") long id, Model model) {
        model.addAttribute("phonebook", phonebookService.getById(id));
        return "update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") long id, Record record) {
        phonebookService.updateRecord(record);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecord(@PathVariable("id") int id) {
        phonebookService.deleteRecord(id);
        return "redirect:/";
    }

}
