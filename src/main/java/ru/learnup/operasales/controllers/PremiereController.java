package ru.learnup.operasales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.learnup.operasales.dto.PremiereDto;
import ru.learnup.operasales.mappers.PremiereMapper;
import ru.learnup.operasales.model.Premiere;
import ru.learnup.operasales.service.PremiereService;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/playbill")
public class PremiereController {

    private final PremiereService premiereService;
    private final PremiereMapper premiereMapper;

    @Autowired
    public PremiereController(PremiereService premiereService, PremiereMapper premiereMapper) {
        this.premiereService = premiereService;
        this.premiereMapper = premiereMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PremiereDto premiereDto) {
        String result = premiereService.addPremiere(premiereMapper.toEntity(premiereDto));
        return result == null
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get")
    public ResponseEntity<Collection<PremiereDto>> read() {
        List<Premiere> premieres = premiereService.findAll();
        return !premieres.isEmpty()
                ? new ResponseEntity<>(premieres.stream()
                .map(premiereMapper::toDto)
                .collect(toList()), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PremiereDto> read(@PathVariable("id") Long id) {
        Premiere premiere = premiereService.findById(id);
        return premiere != null
                ? new ResponseEntity<>(premiereMapper.toDto(premiere), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PremiereDto premiereDto) {
        Premiere premiere = premiereMapper.toEntity(premiereDto);
        return premiereService.editPremiere(id, premiere.getDescription(), premiere.getAgeCategory()) == null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        String result = premiereService.removePremiere(id);
        return result == null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}