package com.example.niceplace.repositories;

import com.example.niceplace.models.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    List<Avatar> findByTitle(String title);
}
