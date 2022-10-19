package controller;

import entity.Reader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class ReaderController {
    private List<Reader> readers = new ArrayList<>();

    @GetMapping("/readers")

    /**
     * add new reader
     */
    @PostMapping("/readers")
    public ResponseEntity addReader(@RequestBody Reader reader){
        readers.add(reader);
        return ResponseEntity.ok().body(reader);
    }
}
