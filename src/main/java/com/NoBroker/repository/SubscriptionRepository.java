package com.NoBroker.repository;

import com.NoBroker.entity.Subscription;
import com.NoBroker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserAndActiveSubscriptionTrue(User user);
    List<Subscription> findByActiveSubscriptionTrueAndStartDateBefore(LocalDateTime currentDateTime);
}

