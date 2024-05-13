package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.models.GenericProducts;
import HomeDelivery.Ecommerce.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private  final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/generate")
    public ResponseEntity getProducts(){
        searchService.createProduct();
        return ResponseEntity.ok().body("created");
    }
    @GetMapping("/paging")
    public Page<GenericProducts> getPage(@RequestParam int pageNumber,
                                         @RequestParam int pageSize){
        return searchService.getPage(pageNumber,pageSize);
    }
    @GetMapping("/slice")
    public Slice<GenericProducts> getSlice(@RequestParam int minPrice,
                                          @RequestParam int maxPrice){
        return searchService.getSlice(minPrice,maxPrice);
    }
    @GetMapping("/list")
    public List<GenericProducts> getList(@RequestParam int minPrice,
                                         @RequestParam int maxPrice){
        return searchService.getList(minPrice,maxPrice);
    }

}
