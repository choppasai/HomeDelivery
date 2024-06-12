package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.dto.ProductDTO;
import HomeDelivery.Ecommerce.models.Products;
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
    @GetMapping("/paging")
    public ResponseEntity<Page<ProductDTO>> getPage(@RequestParam (value="q",required = false) String query,
                                  @RequestParam int pageNumber,
                                  @RequestParam int pageSize,
                                  @RequestParam String sort){


         return ResponseEntity.ok(searchService.getPage(pageNumber,pageSize,sort));
    }
    @GetMapping("/slice")
    public Slice<ProductDTO> getSlice(@RequestParam (value="q",required = false) String query,
                                      @RequestParam int minPrice,
                                      @RequestParam int maxPrice){
        return searchService.getSlice(minPrice,maxPrice);
    }

    @GetMapping("/list")
    public List<ProductDTO> getList(@RequestParam (value="q",required = false) String query,
                                    @RequestParam int minPrice,
                                    @RequestParam int maxPrice){
        return searchService.getList(minPrice,maxPrice);
    }

}
