package com.example.niceplace.controllers;

import com.example.niceplace.models.Avatar;
import com.example.niceplace.models.Image;
import com.example.niceplace.models.Product;
import com.example.niceplace.models.User;
import com.example.niceplace.services.AvatarService;
import com.example.niceplace.services.ProductService;
import com.example.niceplace.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AvatarController {

    private final AvatarService avatarService;
    private final UserService userService;


    @PostMapping("/avatar/create")
    public String createAvatar(MultipartFile ava1, Avatar avatar, Principal principal) throws IOException {

        avatarService.saveAvatar(principal, avatar, ava1);
        return "redirect:/profile";
    }


    @GetMapping("/avatar/{id}")
    public String AvatarInfo(@PathVariable Long id, Model model, Principal principal) {
        Avatar avatar = avatarService.getAvatarById(id);
        model.addAttribute("user", avatarService.getUserByPrincipal(principal));
        model.addAttribute("product", avatar);
        model.addAttribute("images", avatar.getImages());
        return "redirect:/profile";
    }

}
