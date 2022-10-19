package controller;

import entity.Reader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class ReaderController {
    private List<Reader> readers = new ArrayList<>();


    /**
     * get all readers
     */
    @GetMapping("/readers")
    public List<Reader> getReaderList(){
        return readers;
    }

    /**
     * get a specific reader using id
     */

    @GetMapping("/readers/{readerId}")
    public Reader getReader(@PathVariable(name = "readerId") Integer readerId){
        return readers.get(readerId);
    }

    /**
     * add new reader
     */
    @PostMapping("/readers")
    public ResponseEntity addReader(@RequestBody Reader reader){
        readers.add(reader);
        return ResponseEntity.ok().body(reader);
    }
}
