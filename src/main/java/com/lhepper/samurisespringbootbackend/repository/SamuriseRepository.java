package com.lhepper.samurisespringbootbackend.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SamuriseRepository {

    // the two time - used to test set-up of layers
    List<String> list = new ArrayList<>(List.of("Violence", "Speed", "Momentum"));

    public List<String> getWords() {
        return list;
    }

}
