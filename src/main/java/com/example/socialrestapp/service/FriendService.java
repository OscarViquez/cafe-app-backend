package com.example.socialrestapp.service;

import com.example.socialrestapp.exception.UserNotFoundException;
import com.example.socialrestapp.model.Friend;
import com.example.socialrestapp.repo.FriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FriendService {
    private final FriendRepo friendRepo;

    @Autowired
    public FriendService(FriendRepo friendRepo) {
        this.friendRepo = friendRepo;
    }

    public Friend addFriend(Friend friend) {
        friend.setFriendCode(UUID.randomUUID().toString());
        return friendRepo.save(friend);
    }


    public List<Friend> findAllFriends() {
        return friendRepo.findAll();
    }

    public Friend updateFriend(Friend friend) {
        return friendRepo.save(friend);
    }

    public Friend findFriendById(Long id) {
        return friendRepo.findFriendById(id).orElseThrow(() -> new UserNotFoundException("User by id" + id + "Not Found"));
    }


    public void deleteFriend(Long id) {
        friendRepo.deleteFriendById(id);
    }


}
