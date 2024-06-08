package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Repository.GenericRepo;
import HomeDelivery.Ecommerce.models.GenericProducts;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Random;

@Service
public class SearchService {

    private final GenericRepo genericRepo;
    String[] ls = {"T.V","A.C","Refrigerator","Cooler","Washing machine","mixer","Fan","Light"};

    public SearchService(GenericRepo genericRepo) {
        this.genericRepo = genericRepo;
    }

    public void createProduct(){

        for (String l : ls) {
            GenericProducts genericProducts = new GenericProducts();
            genericProducts.setName(l);
            Random random = new Random();
            genericProducts.setPrice( random.nextInt(5000));
//            genericRepo.save(genericProducts);
        }

    }
    public Page<GenericProducts> getPage(int pageNumber,int pageSize){
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize);

        return genericRepo.findAll(pageRequest);
    }
    public List<GenericProducts> getList(int min,int max){
        return genericRepo.findPriceInRange(min,max);
    }
    public Slice<GenericProducts> getSlice(int min,int max){
        return genericRepo.findPriceInRangeSlice(min,max);
    }
    public void sample(){
        genericRepo.findById(8);
    }
}
