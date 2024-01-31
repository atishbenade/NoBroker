package com.NoBroker.Service.ServiceImpl;

import com.NoBroker.Service.SubscriptionService;
import com.NoBroker.entity.Subscription;
import com.NoBroker.entity.User;
import com.NoBroker.exception.ResourceNotFoundException;
import com.NoBroker.repository.SubscriptionRepository;
import com.NoBroker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    public Subscription createSubscription(User user, int durationDays) {
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setStartDate(LocalDateTime.now());
        subscription.setDurationDays(durationDays);
        subscription.setActiveSubscription(true);

        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getUserActiveSubscriptions(User user) {
        return subscriptionRepository.findByUserAndActiveSubscriptionTrue(user);
    }

    public List<Subscription> findExpiredSubscriptions() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return subscriptionRepository
                .findByActiveSubscriptionTrueAndStartDateBefore(currentDateTime.minusDays(1));
    }

    @Override
    public User findById(Long userId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("user not found with id"));
        return user;
    }

    public Subscription expireSubscription(Subscription subscription) {
        subscription.setActiveSubscription(false);
        return subscriptionRepository.save(subscription);
    }
}

