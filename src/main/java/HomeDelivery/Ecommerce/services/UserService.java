package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Repository.BatchRepo;
import HomeDelivery.Ecommerce.Repository.InstructorRepo;
import HomeDelivery.Ecommerce.dto.BatchDTO;
import HomeDelivery.Ecommerce.models.Batch;
import HomeDelivery.Ecommerce.models.InstructorModel;
import HomeDelivery.Ecommerce.models.UserModel;
import HomeDelivery.Ecommerce.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    private final UserRepo userRepo;
    private final InstructorRepo instructorRepo;
    private final BatchRepo batchRepo;

    public UserService(UserRepo userRepo, InstructorRepo instructorRepo, BatchRepo batchRepo) {
        this.userRepo = userRepo;
        this.instructorRepo = instructorRepo;
        this.batchRepo = batchRepo;
    }

    public UserModel createNewUser(String name, String email){
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setEmailId(email);
        userRepo.save(userModel);
        return userModel;
    }
    public Optional<UserModel> getByUser(String name){
        return userRepo.findByName(name);
    }
    public InstructorModel createNewInstructor(String skill, String name, List<BatchDTO> batchDTO){
        InstructorModel instructorModel = new InstructorModel() ;
        instructorModel.setSkill(skill);
        instructorModel.setName(name);
        List<Batch> batchdetails = new ArrayList<Batch>();
        for(BatchDTO b: batchDTO){
            Batch ba = new Batch();
            ba.setBatch_id(b.getId());
            ba.setBatch_name(b.getBatch_Name());
            batchdetails.add(ba);
        }
        instructorModel.setBatch(batchdetails);
        instructorRepo.save(instructorModel);
        return instructorModel;
    }
    public Batch createBatch(String name,int strength){
        Batch batch = new Batch();
        batch.setBatch_name(name);
        batch.setStrength(strength);
        batchRepo.save(batch);
        return batch;
    }
}
