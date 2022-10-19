package controller;

import Repository.ReaderRepository;
import entity.Reader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Exception.ResourceNotFoundException;

import java.util.*;

@RestController
@RequestMapping("/library")
public class ReaderController {
    private ReaderRepository readerRepository;


    /**
     * get all readers
     */
    @GetMapping("/readers")
    public List<Reader> getReaderList(){
        return readerRepository.findAll();
    }

    /**
     * get a specific reader using id
     */

    @GetMapping("/readers/{readerId}")
    public ResponseEntity getReaderById (@PathVariable(name = "readerId") Integer readerId)
            throws ResourceNotFoundException {
            Reader reader = readerRepository.findById(readerId)
                    .orElseThrow(() -> new ResourceNotFoundException("Reader not found by this id: " + readerId));

        return ResponseEntity.ok().body(reader);
    }

    /**
     * add new reader
     */
    @PostMapping("/readers")
    public Reader createReader(@RequestBody Reader reader){
        return readerRepository.save(reader);
    }

    /**
     *  Update a reader
     */

    @PutMapping("/readers/{id}")
    public ResponseEntity<Reader> updateEmployee(@PathVariable(value = "readerId") Integer readerId, @RequestBody Reader readerDetails)
        throws ResourceNotFoundException {
        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new ResourceNotFoundException("Reader not found by this id: " + readerId));

        reader.setEmail(readerDetails.getEmail());
        reader.setName(readerDetails.getName());
        reader.setPhoneNum(readerDetails.getPhoneNum());

        final Reader updatedReader = readerRepository.save(reader);
        return ResponseEntity.ok(updatedReader);
    }
}
