package com.lhepper.samurisespringbootbackend.service;

import java.util.List;

import com.lhepper.samurisespringbootbackend.entity.TimeBlock;
import com.lhepper.samurisespringbootbackend.pojo.TimeBlockEventInformation;

public interface TimeBlockService {
    void updateTimeBlockColor(TimeBlockEventInformation timeBlockInfo);
    TimeBlock getTimeBlockByID(long id);
    void createTimeBlock(TimeBlock timeBlock);
    void createTimeBlockEvent(TimeBlockEventInformation timeBlockEventInformation);
    boolean deleteTimeBlockEvent(TimeBlockEventInformation timeBlockEventInformation);
    List<TimeBlock> getTimeBlockSchedule(long id);
}
