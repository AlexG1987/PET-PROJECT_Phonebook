package com.pet_project.phonebook.service;

import com.pet_project.phonebook.entity.Record;

import java.util.List;

public interface PhonebookService {

    List<Record> getAllRecords();

    Record getById(long id);

    void addRecord(Record record);

    void updateRecord(Record record);

    void deleteRecord(long id);

    List<Record> findByLastName(String searchParam);

}
