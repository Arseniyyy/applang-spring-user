package com.arsenydeveloper.applang.infrastructure.utils.uutils;

import com.arsenydeveloper.applang.domain.model.U;
import com.arsenydeveloper.applang.adapters.api.spring.webmvc.presentation.UPresentationV1;
import com.arsenydeveloper.applang.application.data.UData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UUtils
 */
public class UUtils implements IUUtils {

    @Autowired
    private ModelMapper mapper;

    @Override
    public UData convertToData(U u) {
        return this.mapper.map(u, UData.class);
    }

    @Override
    public List<UData> convertToDataMultiple(List<U> us) {
        return us.stream().map(this::convertToData).collect(Collectors.toList());
    }

    @Override
    public UPresentationV1 convertToUPresentationV1FromUData(UData uData) {
        return this.mapper.map(uData, UPresentationV1.class);
    }

    @Override
    public List<UPresentationV1> convertToListUPresentationV1FromUDataList(List<UData> uDatas) {
        return uDatas.stream().map(this::convertToUPresentationV1FromUData).collect(Collectors.toList());
    }
}
