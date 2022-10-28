package com.controller;

import com.Repository.ReaderRepository;
import com.entity.Reader;
import com.service.ReaderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Exception.ResourceNotFoundException;
import com.dto.ReaderDTO;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/library")
public class ReaderController {
    @Autowired
    private ModelMapper modelMapper;

    private ReaderService readerService;
    public ReaderController(ReaderService readerService){
        super();
        this.readerService = readerService;
    }

    /**
     * get all readers
     */
    @GetMapping("/readers")
    public List<ReaderDTO> getReaderList(){
        return readerService.getReaderList().stream().map(reader -> modelMapper.map(reader, ReaderDTO.class)).collect(Collectors.toList());
    }

    /**
     * get a specific reader using id
     */

    @GetMapping("/readers/{readerId}")
    public ResponseEntity getReaderById (@PathVariable(name = "readerId") Integer readerId)
            throws ResourceNotFoundException {
            Reader reader = readerService.getReaderById(readerId);
            ReaderDTO response = modelMapper.map(reader, ReaderDTO.class);
            return ResponseEntity.ok().body(response);
    }

    /**
     * add new reader
     */
    @PostMapping("/readers")
    public ResponseEntity<ReaderDTO> createReader(@RequestBody ReaderDTO readerDTO){
        Reader readerRequest = modelMapper.map(readerDTO, Reader.class);
        Reader reader = readerService.createReader(readerRequest);

        ReaderDTO readerResponse = modelMapper.map(reader, ReaderDTO.class);
        return new ResponseEntity<ReaderDTO>(readerResponse, HttpStatus.CREATED);
    }

    /**
     *  Update a reader
     */

    @PutMapping("/readers/{readerId}")
    public ResponseEntity<ReaderDTO> updateReader(@PathVariable(value = "readerId") Integer readerId, @RequestBody ReaderDTO readerDTO)
        throws ResourceNotFoundException {
        Reader readerRequest = modelMapper.map(readerDTO, Reader.class);
        Reader reader = readerService.updateReader(readerId, readerRequest);

        ReaderDTO readerResponse = modelMapper.map(reader, ReaderDTO.class);
        return ResponseEntity.ok().body(readerResponse);
    }

    @DeleteMapping("/readers/{readerId}")
    public Map<String, Boolean> deleteReader(@PathVariable(value = "readerId") Integer readerId) throws ResourceNotFoundException {
        return readerService.deleteReader(readerId);
    }
}
