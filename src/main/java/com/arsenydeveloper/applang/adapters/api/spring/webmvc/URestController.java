package com.arsenydeveloper.applang.adapters.api.spring.webmvc;

import com.arsenydeveloper.applang.application.api.CreateApi;
import com.arsenydeveloper.applang.application.api.DeleteByIdApi;
import com.arsenydeveloper.applang.application.api.FindAllApi;
import com.arsenydeveloper.applang.application.api.FindByIdApi;
import com.arsenydeveloper.applang.application.api.UpdateByIdApi;
import com.arsenydeveloper.applang.application.data.UData;
import com.arsenydeveloper.applang.infrastructure.utils.uutils.UUtils;
import com.arsenydeveloper.applang.adapters.api.spring.webmvc.presentation.UPresentationV1;
import com.arsenydeveloper.applang.domain.model.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.UUID;
import java.util.Map;
import java.util.List;

/**
 * FindByIdRestController is an API adapter.
 */
@RestController
public class URestController {

    @Autowired
    private final FindAllApi findAllApi;

    @Autowired
    private final FindByIdApi findByIdApi;

    @Autowired
    private final CreateApi createApi;

    @Autowired
    private final UpdateByIdApi updateByIdApi;

    @Autowired
    private final DeleteByIdApi deleteByIdApi;

    @Autowired
    private final UUtils utils;

    public URestController(
        FindAllApi findAllApi,
        FindByIdApi findByIdApi,
        CreateApi createApi,
        UpdateByIdApi updateByIdApi,
        DeleteByIdApi deleteByIdApi,
        UUtils utils
    ) {
        this.findAllApi = findAllApi;
        this.findByIdApi = findByIdApi;
        this.createApi = createApi;
        this.updateByIdApi = updateByIdApi;
        this.deleteByIdApi = deleteByIdApi;
        this.utils = utils;
    }

    @GetMapping(
        value = "${info.api.u-url}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<UPresentationV1>> getAll() {
        List<UData> uDataList = this.findAllApi.findAll();
        List<UPresentationV1> uPresentationV1List = this.utils.convertToListUPresentationV1FromUDataList(uDataList);

        return ResponseEntity.ok().body(uPresentationV1List);
    }

    @GetMapping(
        value = "${info.api.u-url}/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UPresentationV1> getDetailedU(@PathVariable UUID id) {
        UData uData = this.findByIdApi.findById(id);
        UPresentationV1 uPresentationV1 = this.utils.convertToUPresentationV1FromUData(uData);

        return ResponseEntity.ok().body(uPresentationV1);
    }

    @PostMapping(
        value = "${info.api.u-url}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UPresentationV1> createU(@RequestBody @Valid U body) {
        UData uData = this.createApi.create(body);
        UPresentationV1 uPresentationV1 = this.utils.convertToUPresentationV1FromUData(uData);

        return new ResponseEntity<>(uPresentationV1, HttpStatus.CREATED);
    }

    @PatchMapping(
        value = "${info.api.u-url}/{id}",
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<UPresentationV1> partialUpdateU(@PathVariable UUID id,  @RequestBody @Valid Map<String, Object> fields) {
        UData uData = this.updateByIdApi.update(id, fields);
        UPresentationV1 uPresentationV1 = this.utils.convertToUPresentationV1FromUData(uData);

        return ResponseEntity.ok().body(uPresentationV1);
    }

    @DeleteMapping(value = "${info.api.u-url}/{id}")
    public ResponseEntity<Void> deleteDetailedU(@PathVariable UUID id) {
        this.deleteByIdApi.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
