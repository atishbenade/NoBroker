package com.NoBroker.service.serviceImpl;

import com.NoBroker.entity.OwnerPlan;
import com.NoBroker.payload.OwnerPlanDto;
import com.NoBroker.repository.OwnerPlaneRepository;
import com.NoBroker.service.OwnerPlaneService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OwnerPlaneServiceImpl implements OwnerPlaneService {

    private OwnerPlaneRepository ownerPlaneRepository;

    private ModelMapper modelMapper;

    public OwnerPlaneServiceImpl(OwnerPlaneRepository ownerPlaneRepository, ModelMapper modelMapper) {
        this.ownerPlaneRepository = ownerPlaneRepository;
        this.modelMapper = modelMapper;
    }

    public OwnerPlanDto createOwnerPlaneDto(OwnerPlanDto ownerPlanDto){
        OwnerPlan ownerPlan = maptoEntity(ownerPlanDto);
        OwnerPlan saveOwnerPlan = ownerPlaneRepository.save(ownerPlan);
        return maptoDto(saveOwnerPlan);


    }







    OwnerPlan maptoEntity(OwnerPlanDto ownerPlanDto){
        OwnerPlan ownerPlan = modelMapper.map(ownerPlanDto, OwnerPlan.class);
        return ownerPlan;
    }

    OwnerPlanDto maptoDto(OwnerPlan ownerPlan){
        OwnerPlanDto ownerPlanDto = modelMapper.map(ownerPlan, OwnerPlanDto.class);
        return ownerPlanDto;
    }
}
