package com.lhepper.samurisespringbootbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhepper.samurisespringbootbackend.entity.TaskList;
import com.lhepper.samurisespringbootbackend.entity.TimeBlock;
import com.lhepper.samurisespringbootbackend.exception.ResourceNotFoundException;
import com.lhepper.samurisespringbootbackend.pojo.TimeBlockEventInformation;
import com.lhepper.samurisespringbootbackend.repository.TimeBlockRepository;

@Service
public class TimeBlockServiceImpl implements TimeBlockService {

    @Autowired
    TimeBlockRepository timeBlockRepository;

    @Autowired
    TaskListService taskListService;

    @Autowired
    DayService dayService;

    @Override
    public void createTimeBlock(TimeBlock timeBlock) {
        timeBlockRepository.save(timeBlock);
    }

    @Override
    public TimeBlock getTimeBlockByID(long id) {
        Optional<TimeBlock> foundTimeBlock = timeBlockRepository.findById(id);
        return foundTimeBlock.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public void createTimeBlockEvent(TimeBlockEventInformation timeBlockEventInformation) {

        Optional<TimeBlock> startTimeBlockOption = timeBlockRepository
                .getTimeBlockByDayIdAndStartTime(timeBlockEventInformation.getDayID(),
                        timeBlockEventInformation.getStartTime());

        TimeBlock startTimeBlock = null;
        if (startTimeBlockOption.isPresent()) {
            startTimeBlock = startTimeBlockOption.get();
        } else {
            new ResourceNotFoundException(timeBlockEventInformation.getTimeBlockId());
        }

        if (startTimeBlockOption.isPresent()) {
            startTimeBlock = startTimeBlockOption.get();
            startTimeBlock.setStartOfBlock(true);
            startTimeBlock.setScheduled(true);
            startTimeBlock.setName(timeBlockEventInformation.getName());
            timeBlockRepository.save(startTimeBlock);
        } else {
            new ResourceNotFoundException(timeBlockEventInformation.getTimeBlockId());
        }

        long startingBlockId = startTimeBlock.getId();
        int eventLength = timeBlockEventInformation.getLength();
        for (long i = startingBlockId; i < startingBlockId + eventLength; i++) {

            Optional<TimeBlock> updateTimeBlockOption = timeBlockRepository.findById(i);

            if (updateTimeBlockOption.isPresent()) {
                TimeBlock updateTimeBlock = updateTimeBlockOption.get();
                updateTimeBlock.setScheduled(true);
                updateTimeBlock.setName(timeBlockEventInformation.getName());
                timeBlockRepository.save(updateTimeBlock);
            }
        }

        TaskList newTaskList = new TaskList(timeBlockEventInformation.getName(),
                dayService.getDayByID(timeBlockEventInformation.getDayID()));
        taskListService.createTaskList(newTaskList);

    }

    @Override
    public boolean deleteTimeBlockEvent(TimeBlockEventInformation timeBlockEventInformation) {
        Optional<TimeBlock> startTimeBlockOption = timeBlockRepository
                .getTimeBlockByDayIdAndStartTime(timeBlockEventInformation.getDayID(),
                        timeBlockEventInformation.getStartTime());
        if (startTimeBlockOption.isPresent()) {
            TimeBlock startTimeBlock = startTimeBlockOption.get();
            startTimeBlock.setStartOfBlock(false);
            startTimeBlock.setScheduled(false);
            startTimeBlock.setName(null);
            timeBlockRepository.save(startTimeBlock);
        } else {
            return false;
        }

        for (long i = timeBlockEventInformation.getTimeBlockId(); i < timeBlockEventInformation.getTimeBlockId()
                + timeBlockEventInformation.getLength(); i++) {
            Optional<TimeBlock> updateTimeBlockOption = timeBlockRepository.findById(i);
            if (updateTimeBlockOption.isPresent()) {
                TimeBlock updateTimeBlock = updateTimeBlockOption.get();
                updateTimeBlock.setScheduled(false);
                updateTimeBlock.setName(null);
                timeBlockRepository.save(updateTimeBlock);
            }
        }
        taskListService.deleteTaskList(timeBlockEventInformation.getTaskListId());

        return true;
    }

    @Override
    public List<TimeBlock> getTimeBlockSchedule(long id) {
        Optional<List<TimeBlock>> schedule = timeBlockRepository.getTimeBlockSchedule(id);
        if (schedule.isPresent()) {
            System.out.println(schedule.get());
        }
        return schedule.get();

    }
}
