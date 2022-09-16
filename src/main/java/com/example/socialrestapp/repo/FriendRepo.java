package com.example.socialrestapp.repo;

import com.example.socialrestapp.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendRepo extends JpaRepository<Friend, Long> {
    void deleteFriendById(Long id);

    Optional<Friend> findFriendById(Long id);
}
