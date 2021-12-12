package com.example.web4back.controllers;

import com.example.web4back.model.EntryBean;
import com.example.web4back.model.UserBean;
import com.example.web4back.service.EntryService;
import com.example.web4back.service.UserService;
import com.example.web4back.util.HitChecker;
import com.example.web4back.util.RawEntry;
import com.example.web4back.util.StatusObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final UserService userService;
    private final HitChecker hitChecker;
    private final EntryService entryService;

    public MainController(@Autowired UserService userService, @Autowired EntryService entryService,
                          @Autowired HitChecker hitChecker) {
        this.userService = userService;
        this.hitChecker = hitChecker;
        this.entryService = entryService;
    }

    @CrossOrigin
    @PostMapping("/add")
    public List<EntryBean> addEntry(@RequestBody RawEntry entry) {
        UserBean user = userService.findByLogin(entry.getUserName());
        EntryBean entryBean = new EntryBean(entry.getX(), entry.getY(), entry.getR(),
                hitChecker.checkIfHit(entry.getX(), entry.getY(), entry.getR()));
        if (user != null) {
            entryBean.setUser(user);
            entryBean = entryService.saveEntry(entryBean);
            return entryService.getAllEntries(user);
        }
        return new ArrayList<>();
    }

    @CrossOrigin
    @PostMapping("/clear")
    public List<EntryBean> clearAll(@RequestBody StatusObject statusObject) {
        UserBean user = userService.findByLogin(statusObject.getName());
        if (user != null) {
            entryService.clearAllEntries(user);
        }
        return new ArrayList<>();
    }

    @CrossOrigin
    @PostMapping("/get-all")
    public List<EntryBean> getAll(@RequestBody StatusObject statusObject) {
        UserBean user = userService.findByLogin(statusObject.getName());
        if (user != null) {
            return entryService.getAllEntries(user);
        }
        return new ArrayList<>();
    }


}
