package com.example.web4back.service;

import com.example.web4back.model.EntryBean;
import com.example.web4back.model.UserBean;
import com.example.web4back.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryService {

    private final EntryRepository entryRepository;

    @Autowired
    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public EntryBean saveEntry(EntryBean entry) {
        return entryRepository.save(entry);
    }

    public List<EntryBean> getAllEntries(UserBean userBean) {
        return entryRepository.findAllByUser(userBean);
    }

    public void clearAllEntries(UserBean user) {
        List<Long> ids = (List<Long>) entryRepository.findAllByUser(user).stream().map(EntryBean::getId).collect(Collectors.toList());
        entryRepository.deleteAllByIdInBatch(ids);
    }
}
