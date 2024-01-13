package com.arsenydeveloper.applang.user.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arsenydeveloper.applang.user.persistence.U;
import com.arsenydeveloper.applang.user.persistence.dto.UDTO;

/**
 * UUtils
 */
@Component
public class UUtils {

    private final ModelMapper modelMapper;

    @Autowired
    public UUtils(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UDTO convertToDTO(U u) {
        return modelMapper.map(u, UDTO.class);
    }

    public List<UDTO> convertToDTOMultiple(List<U> us) {
        return us.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
