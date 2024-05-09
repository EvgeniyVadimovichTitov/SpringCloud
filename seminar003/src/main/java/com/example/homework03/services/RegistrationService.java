package com.example.homework03.services;

import com.example.homework03.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public void processRegistration(String name, String email, int age){
       User newUser = userService.createUser(name,age,email);
       dataProcessingService.addUserToList(newUser);
       notificationService.sendNotification("Из RegistrationService: ");
       notificationService.notifyUser(newUser);
    }
}
