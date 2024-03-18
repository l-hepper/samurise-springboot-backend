package com.lhepper.samurisespringbootbackend.service;

import com.lhepper.samurisespringbootbackend.entity.TimeBlock;

public interface TimeBlockService {
    TimeBlock getTimeBlockByID(long id);
    void createTimeBlock(TimeBlock timeBlock);
}
