package com.example.project03webbaseapp.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PictureRepo extends CrudRepository<Picture, Integer> {

    Picture findPictureByPictureId(Integer pictureId);

    Picture findPictureByPictureName(String name);

    List<Picture> findAll();

}
