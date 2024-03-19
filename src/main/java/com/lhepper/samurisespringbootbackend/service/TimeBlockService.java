package com.lhepper.samurisespringbootbackend.service;

import com.lhepper.samurisespringbootbackend.entity.TimeBlock;
import com.lhepper.samurisespringbootbackend.pojo.TimeBlockEventInformation;

public interface TimeBlockService {
    TimeBlock getTimeBlockByID(long id);
    void createTimeBlock(TimeBlock timeBlock);
    void createTimeBlockEvent(TimeBlockEventInformation timeBlockEventInformation);
    boolean deleteTimeBlockEvent(TimeBlockEventInformation timeBlockEventInformation);
}
