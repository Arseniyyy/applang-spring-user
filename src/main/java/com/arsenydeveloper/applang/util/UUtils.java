package com.arsenydeveloper.applang.util;

import com.arsenydeveloper.applang.persistence.U;
import com.arsenydeveloper.applang.persistence.data.UData;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public UData convertToDTO(U u) {
        return modelMapper.map(u, UData.class);
    }

    public List<UData> convertToDTOMultiple(List<U> us) {
        return us.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
