package com.example.project03webbaseapp.database;

import org.springframework.data.repository.CrudRepository;

public interface CaptionRepo extends CrudRepository<Caption, Integer>{

    Caption findCaptionByCaptionId(Integer captionId);
}
