package com.example.project03webbaseapp.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CaptionRepo extends CrudRepository<Caption, Integer>{

    Caption findCaptionByCaptionId(Integer captionId);

    Caption findCaptionByUserId(Integer userId);

    List<Caption> findAllByPictureId(Integer pictureId);


}
