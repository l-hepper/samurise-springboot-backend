package com.lhepper.samurisespringbootbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.entity.TimeBlock;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;
import com.lhepper.samurisespringbootbackend.repository.TimeBlockRepository;

@Service
public class TimeBlockServiceImpl implements TimeBlockService {

    @Autowired
    TimeBlockRepository timeBlockRepository;

    @Override
    public void createTimeBlock(TimeBlock timeBlock) {
        timeBlockRepository.save(timeBlock);
    }

    @Override
    public TimeBlock getTimeBlockByID(long id) {
        Optional<TimeBlock> foundTimeBlock = timeBlockRepository.findById(id);
        return foundTimeBlock.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
