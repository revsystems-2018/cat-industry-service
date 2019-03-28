package com.rev.cat.catservice.web;

import com.google.common.net.HttpHeaders;
import com.rev.cat.catservice.domain.Product;
import com.rev.cat.catservice.dto.ProductRequestDTO;
import com.rev.cat.catservice.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
@Api(value = "products", description = "Operations related to Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll() {
        return productService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Product findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product insert(@RequestBody ProductRequestDTO dto) {
        return productService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Product delete(@PathVariable String id) {
        return productService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Product update(@PathVariable String id, @RequestBody ProductRequestDTO dto) {
        return productService.update(id, dto);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/{id}/product",
            headers = HttpHeaders.CONTENT_TYPE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity uploadFile(@PathVariable String id,
                                     @RequestParam("product") MultipartFile inputFile) {
        Product savedEmployee = productService.findById(id);
        if (savedEmployee == null) {
//            throw new NotFoundException(Employee.class.getTypeName() + " id:" + id + " Not Found");
        }
        if (!inputFile.isEmpty()) {
            try {
                productService.savePicture(id, inputFile.getInputStream());
            } catch (IOException e) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
