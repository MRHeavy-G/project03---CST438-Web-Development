package com.example.project03webbaseapp.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CaptionRepo extends CrudRepository<Caption, Integer>{

    Caption findCaptionByCaptionId(Integer captionId);

    Caption findCaptionByUsername(String username);

    List<Caption> findAllByUsername(String username);
    //List<Caption> findAllByPictureId(Integer pictureId);


    List<Caption> findCaptionByPictureId(Integer picId);

}
