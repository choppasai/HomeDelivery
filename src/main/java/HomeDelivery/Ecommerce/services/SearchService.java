package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Repository.ProductRepo;
import HomeDelivery.Ecommerce.dto.ProductDTO;
import HomeDelivery.Ecommerce.models.Products;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    public SearchService(ProductRepo productRepo, ModelMapper modelMapper) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
    }

    public Page<ProductDTO> getPage(int pageNumber, int pageSize,String sorting){

        Page<Products> productsPage = switchMethod(pageNumber,pageSize,sorting);
        Page<ProductDTO> productDTOPage = productsPage.map(ProductDTO::toProductDTO);
        return productDTOPage;
    }
    public Page<Products> switchMethod(int pageNumber, int pageSize,String sorting){
        System.out.println("entered");
        return switch (sorting){
            case "price-asc" ->
                productRepo.findAll(PageRequest.of(pageNumber,pageSize,Sort.by("price").ascending()));
            case "price-desc" ->
                    productRepo.findAll(PageRequest.of(pageNumber,pageSize,Sort.Direction.DESC,"price"));

            case "title-desc"->
                productRepo.findAll(PageRequest.of(pageNumber,pageSize,Sort.Direction.ASC,"title"));

            default->
                productRepo.findAll(PageRequest.of(pageNumber,pageSize));

        };
    }
    public List<ProductDTO> getList(int min,int max){
        List<Products> productsList = productRepo.findPriceInRange(min,max);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Products products:productsList){
            ProductDTO productDTO = new ProductDTO();
            modelMapper.map(products,productDTO);
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }
    public Slice<ProductDTO> getSlice(int min,int max){
        Slice<Products> productsSlice = productRepo.findPriceInRangeSlice(min,max);
        return productsSlice.map(ProductDTO::toProductDTO);
    }


}
