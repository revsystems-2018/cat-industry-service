package com.rev.cat.catservice.service;

import com.rev.cat.catservice.domain.Product;
import com.rev.cat.catservice.dto.ProductRequestDTO;
import com.rev.cat.catservice.repository.BrandRepository;
import com.rev.cat.catservice.repository.CatalogRepository;
import com.rev.cat.catservice.repository.ProductRepository;
import com.rev.cat.catservice.service.bootstrap.GenericService;
import com.rev.cat.catservice.service.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ProductService extends GenericService<Product, ProductRequestDTO> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product delete(String id) {
        Product product = findById(id);
        productRepository.delete(product);
        return product;
    }

    @Override
    public Product insert(ProductRequestDTO dto) {
        Product product = buildCreateSafetyEquipment(dto);
        product = productRepository.insert(product);
        return product;
    }

    @Override
    public Product update(String id, ProductRequestDTO dto) {
        Product product = findById(id);
        buildUpdateSafetyEquipment(product, dto);
        productRepository.save(product);
        return product;
    }

    public void savePicture(String id, InputStream inputStream) {
        Product employeePersisted = findById(id);
        try {
            Byte[] bytes = ImageUtils.inputStreamToByteArray(inputStream);
            employeePersisted.getImage().add(bytes);
            productRepository.save(employeePersisted);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Product buildCreateSafetyEquipment(ProductRequestDTO dto) {
        Product product = new Product();

        setProductInformation(product, dto);

        return product;
    }

    private void buildUpdateSafetyEquipment(Product product, ProductRequestDTO dto) {

        setProductInformation(product, dto);
    }

    private void setProductInformation(Product product, ProductRequestDTO dto){
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCatalog(catalogRepository.findByName(dto.getCatalogName()));
        product.setBrand(brandRepository.findByName(dto.getBrandName()));
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());
    }
}
