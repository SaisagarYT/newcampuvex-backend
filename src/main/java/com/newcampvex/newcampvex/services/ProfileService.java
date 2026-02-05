package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Profile createProfile(Profile profile);
    Profile updateProfile(String id, Profile profile);
    Optional<Profile> getProfile(String id);
    Optional<Profile> getProfileByUserId(String userId);
    void deleteProfile(String id);
    List<Profile> getAllProfiles();
}
