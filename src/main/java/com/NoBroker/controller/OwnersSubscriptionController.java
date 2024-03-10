package com.NoBroker.controller;

import com.NoBroker.Service.SubscriptionService;
import com.NoBroker.entity.Subscription;
import com.NoBroker.entity.User;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class OwnersSubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;


    @PostMapping("/create")
    public ResponseEntity<String> createSubscription(@RequestParam Long userId, @RequestParam int durationDays) {
        User user = subscriptionService.findById(userId);
        Subscription subscription = subscriptionService.createSubscription(user, durationDays);
        return ResponseEntity.ok("Subscription created with ID: " + subscription.getId());
    }




    @Scheduled(fixedRate = 86400000) // Run every 24 hours
    public void expireSubscriptions() {
        List<Subscription> expiredSubscriptions = subscriptionService.findExpiredSubscriptions();

        for (Subscription subscription : expiredSubscriptions) {
            subscriptionService.expireSubscription(subscription);
        }
    }
}

