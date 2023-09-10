package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.MaterialQuote;
import za.ac.cput.service.MaterialQuoteService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/materialQuote")
public class MaterialQuoteController {

    @Autowired
    private MaterialQuoteService materialQuoteService;

    @PostMapping("/create")
    public MaterialQuote create(@RequestBody MaterialQuote materialQuote) {
        return materialQuoteService.create(materialQuote);
    }

    @GetMapping("/read/{id}")
    public MaterialQuote read(@PathVariable String id) {
        return materialQuoteService.read(id);
    }

    @PostMapping("/update")
    public MaterialQuote update(@RequestBody MaterialQuote materialQuote) {
        return materialQuoteService.update(materialQuote);
    }

    @RequestMapping("/getAll")
    public List<MaterialQuote> getAll() {
        return materialQuoteService.getAll();
    }
}
