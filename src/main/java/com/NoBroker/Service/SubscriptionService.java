package com.NoBroker.Service;

import com.NoBroker.entity.Subscription;
import com.NoBroker.entity.User;

import java.util.List;

public interface SubscriptionService {
    public Subscription createSubscription(User user, int durationDays);

    public Subscription expireSubscription(Subscription subscription);

    public List<Subscription> findExpiredSubscriptions();


    User findById(Long userId);
}
