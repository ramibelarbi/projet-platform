package com.example.smartcity.repos;

import com.example.smartcity.models.Administartion;
import com.example.smartcity.models.Notification;
import com.example.smartcity.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationRepo extends JpaRepository<Notification,Long> {
    Optional<Notification> getNotificationById(Long Id);
    List<Notification> getNotificationsByEmploye(Personne personne);
    List<Notification> getNotificationByAdministartion(Administartion administartion);
    List<Notification> getNotificationByPersonne(Personne personne);
}
