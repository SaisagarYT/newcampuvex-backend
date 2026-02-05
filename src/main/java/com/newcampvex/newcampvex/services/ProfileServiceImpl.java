package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Profile;
import com.newcampvex.newcampvex.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(String id, Profile profile) {
        profile.setId(id);
        return profileRepository.save(profile);
    }

    @Override
    public Optional<Profile> getProfile(String id) {
        return profileRepository.findById(id);
    }

    @Override
    public Optional<Profile> getProfileByUserId(String userId) {
        return profileRepository.findByUserId(userId);
    }

    @Override
    public void deleteProfile(String id) {
        profileRepository.deleteById(id);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
}
