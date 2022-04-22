package com.example.smartcity.controllers;


import com.example.smartcity.models.Administartion;
import com.example.smartcity.models.Gouvernerat;
import com.example.smartcity.models.Notification;
import com.example.smartcity.models.Personne;
import com.example.smartcity.services.AdministrationService;
import com.example.smartcity.services.NotificationService;
import com.example.smartcity.services.PersonneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@AllArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {
    public final NotificationService notificationService;
    public final PersonneService personneService;
    public final AdministrationService administrationService;
    @GetMapping("/find/{id}")
    ResponseEntity<Notification> getNotification(@PathVariable("id") Long id){
        Notification notification = notificationService.getNotification(id);
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    @GetMapping("/personne/{id}")
    ResponseEntity<List<Notification>> getPersonneNotifications(@PathVariable("id") Long id){
        Personne personne = personneService.getPersonneById(id);
        List<Notification> notifications = notificationService.getNotificationPersonne(personne);
        return new ResponseEntity<>(notifications,HttpStatus.OK);
    }

    @GetMapping("/employe/{id}")
    ResponseEntity<List<Notification>> getEmployeNotifications(@PathVariable("id") Long id){
        Personne employe = personneService.getPersonneById(id);
        List<Notification> notifications = notificationService.getNotificationEmploye(employe);
        return new ResponseEntity<>(notifications,HttpStatus.OK);
    }

    @GetMapping("administration/{id}")
    ResponseEntity<List<Notification>> getAdministrationNotifications(@PathVariable("id") Long id){
        Administartion administartion = administrationService.getAdministration(id);
        List<Notification> notifications = notificationService.getNotificationAdministartion(administartion);
        return new ResponseEntity<>(notifications,HttpStatus.OK);
    }


    @PostMapping("/ville/{ville}/add")
    ResponseEntity<List<Notification>> addNotificationVille(@PathVariable("ville") String ville,@RequestBody Notification notification){
        List<Notification> notifications = notificationService.addNotificationVille(notification,ville);
        return  new ResponseEntity<>(notifications,HttpStatus.CREATED);
    }

    @PostMapping("/gouvernerat/{gouvernerat}/add")
    ResponseEntity<List<Notification>> addNotificationGouvernerat(@PathVariable("gouvernerat") Gouvernerat gouvernerat, @RequestBody Notification notification){
        List<Notification> notifications = notificationService.addNotificationGouvernerat(notification,gouvernerat);
        return  new ResponseEntity<>(notifications,HttpStatus.CREATED);
    }

    @PostMapping("/add")
    ResponseEntity<Notification> addNotificationPerson(@RequestBody Notification notification){
        Notification newNotification = notificationService.addNotificationPerson(notification);
        return new ResponseEntity<>(notification,HttpStatus.CREATED);
    }
}
