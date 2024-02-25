package com.arsenydeveloper.applang.infrastructure.utils.uutils;

import com.arsenydeveloper.applang.adapters.api.spring.webmvc.presentation.UPresentationV1;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.domain.model.U;
import java.util.List;

/**
 * IUUtils
 */
public interface IUUtils {

    UData convertToData(U u);

    List<UData> convertToDataMultiple(List<U> us);

    UPresentationV1 convertToUPresentationV1FromUData(UData uData);

    List<UPresentationV1> convertToListUPresentationV1FromUDataList(List<UData> uDatas);
}
