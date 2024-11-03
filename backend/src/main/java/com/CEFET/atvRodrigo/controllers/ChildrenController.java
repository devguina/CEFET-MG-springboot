package com.CEFET.atvRodrigo.controllers;

import com.CEFET.atvRodrigo.dto.ChildDTO;
import com.CEFET.atvRodrigo.models.Child;
import com.CEFET.atvRodrigo.services.ChildService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/child", produces = {"application/json"})
@Tag(name = "/child")
public class ChildrenController {

    @Autowired
    ChildService service;

    @Operation(summary = "Return all children", method = "GET")
    @GetMapping(value = "/")
    public List<Child> getAllChild() {
        return service.findAllChildies();
    }

    @Operation(summary = "Return one children by id", method = "GET")
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getChild(@PathVariable UUID id) {
        Optional<Child> childOptional = service.findChildById(id);
        if (childOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(childOptional);
        } else {
            return null;
        }
    }

    @Operation(summary = "Get child by name", method = "GET")
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<?> getNameChild(@PathVariable String name) {
        List<Child> childList = service.findChildByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(childList);
    }

    @Operation(summary = "create children", method = "POST")
    @PostMapping(value = "/")
    public ResponseEntity<?> postChild(@RequestBody ChildDTO dto) {
        Child child = service.addChild(dto);
        return ResponseEntity.status(HttpStatus.OK).body(child);
    }

    @Operation(summary = "Delete children by id", method = "DELETE")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteChild(@PathVariable UUID id) {
        Optional<Child> childOptional = service.findChildById(id);
        if (childOptional.isPresent()) {
            service.deleteChildById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Child has been deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Child has not found");
        }

    }

    @Operation(summary = "Update children by id", method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> putChild(@RequestParam UUID id,
                                      @RequestBody @Valid ChildDTO dto) {
        Optional<Child> childOptional = service.findChildById(id);
        if (childOptional.isPresent()) {
            Child child = service.updateChildById(id, dto);
            return ResponseEntity.status(HttpStatus.OK).body(child);
        } else {
            return null;
        }
    }

}
