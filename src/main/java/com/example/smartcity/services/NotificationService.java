package com.example.smartcity.services;


import com.example.smartcity.exceptions.NotFoundException;
import com.example.smartcity.models.Administartion;
import com.example.smartcity.models.Gouvernerat;
import com.example.smartcity.models.Notification;
import com.example.smartcity.models.Personne;
import com.example.smartcity.repos.NotificationRepo;
import com.example.smartcity.repos.PersonneRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @AllArgsConstructor
public class NotificationService {
    private final NotificationRepo notificationRepo;
    private final PersonneRepo personneRepo;
    public Notification addNotificationPerson(Notification notification){
        return notificationRepo.save(notification);
    }
    public List<Notification> addNotificationVille(Notification notification,String ville){
        Notification newNotification= notification;
        List<Notification> notifications = new ArrayList<Notification>();
        for (Personne p:personneRepo.findPersonneByAdresse_Ville(ville)) {
            newNotification.setPersonne(p);
            notifications.add(newNotification);
        }
        return notificationRepo.saveAll(notifications);
    }
    public List<Notification> addNotificationGouvernerat(Notification notification, Gouvernerat gouvernerat){
        Notification newNotification = notification;
        List<Notification> notifications = new ArrayList<Notification>();
        for (Personne p:personneRepo.findPersonnesByAdresse_Gouvernerat(gouvernerat)) {
            newNotification.setPersonne(p);
            notifications.add(newNotification);
        }
        return notificationRepo.saveAll(notifications);
    }
    public List<Notification> getNotificationPersonne(Personne personne){
        return notificationRepo.getNotificationByPersonne(personne);
    }

    public List<Notification> getNotificationEmploye(Personne employe){
        return notificationRepo.getNotificationsByEmploye(employe);
    }

    public List<Notification> getNotificationAdministartion(Administartion administartion){
        return notificationRepo.getNotificationByAdministartion(administartion);
    }

    public Notification getNotification(Long id){
        return notificationRepo.getNotificationById(id).orElseThrow(()-> new NotFoundException("Notification avec l'id "+ id + " n'existe pas"));
    }

}
