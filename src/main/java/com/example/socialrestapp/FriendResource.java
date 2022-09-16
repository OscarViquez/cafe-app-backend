package com.example.socialrestapp;

import com.example.socialrestapp.model.Friend;
import com.example.socialrestapp.service.FriendService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendResource {
    private final FriendService friendService;

    public FriendResource(FriendService friendService) {
        this.friendService = friendService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Friend>> getAllFriends () {
        List<Friend> friends = friendService.findAllFriends();
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Friend> getFriendById (@PathVariable("id") Long id) {
        Friend friend = friendService.findFriendById(id);
        return new ResponseEntity<>(friend, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Friend> addFriend(@RequestBody Friend friend) {
        Friend newFriend = friendService.addFriend(friend);
        return new ResponseEntity<>(newFriend, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Friend> updateFriend(@RequestBody Friend friend) {
        Friend updateFriend = friendService.updateFriend(friend);
        return new ResponseEntity<>(updateFriend, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFriend(@PathVariable("id") Long id) {
        friendService.deleteFriend(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
