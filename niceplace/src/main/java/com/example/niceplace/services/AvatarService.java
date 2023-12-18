package com.example.niceplace.services;

import com.example.niceplace.models.Avatar;
import com.example.niceplace.models.Image;

import com.example.niceplace.models.User;
import com.example.niceplace.repositories.AvatarRepository;

import com.example.niceplace.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AvatarService {
    private final AvatarRepository avatarRepository;
    private final UserRepository userRepository;

    public List<Avatar> listAvatars(String title) {
        if (title != null) return avatarRepository.findByTitle(title);
        return avatarRepository.findAll();
    }

    public void saveAvatar(Principal principal, Avatar avatar, MultipartFile ava1) throws IOException {
        avatar.setUser(getUserByPrincipal(principal));
        Image image1;

        if (ava1.getSize() != 0) {
            image1 = toImageEntity(ava1);
            image1.setPreviewImage(true);
            avatar.addImageToAvatar(image1);
        }

        log.info("Saving new Product. Title: {}; Author email: {}", avatar.getTitle());
        Avatar avatarFromDb = avatarRepository.save(avatar);
        avatarFromDb.setPreviewImageId(avatarFromDb.getImages().getFirst().getId());
        avatarRepository.save(avatar);
    }


    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public Avatar getAvatarById(Long id) {
        return avatarRepository.findById(id).orElse(null);
    }
}
