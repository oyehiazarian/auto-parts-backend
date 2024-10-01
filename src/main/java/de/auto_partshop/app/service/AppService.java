package de.auto_partshop.app.service;


import de.auto_partshop.app.repository.DataRepository;
import de.auto_partshop.app.models.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AppService {

    private DataRepository dataRepository;

    public List<Movie> getAllParts(){
        return dataRepository.findAll();
    }

}
