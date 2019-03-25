package com.rev.cat.catservice.service;

import com.rev.cat.catservice.domain.Catalog;
import com.rev.cat.catservice.dto.CatalogRequestDTO;
import com.rev.cat.catservice.repository.CatalogRepository;
import com.rev.cat.catservice.service.bootstrap.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CatalogService extends GenericService<Catalog, CatalogRequestDTO> {

    @Autowired
    private CatalogRepository ruleRepository;

    @Override
    public List<Catalog> findAll() {
        return ruleRepository.findAll();
    }

    @Override
    public Catalog findById(String id) {
        return ruleRepository.findOne(id);
    }

    @Override
    public Catalog delete(String id) {
        Catalog catalog = findById(id);
        ruleRepository.delete(catalog);
        return catalog;
    }

    @Override
    public Catalog insert(CatalogRequestDTO dto) {
        Catalog catalog = buildCreateRules(dto);
        catalog = ruleRepository.insert(catalog);

        return catalog;
    }

    @Override
    public Catalog update(String id, CatalogRequestDTO dto) {
        Catalog rule = findById(id);
        buildUpdateRules(rule, dto);
        ruleRepository.save(rule);

        return rule;
    }

    private Catalog buildCreateRules(CatalogRequestDTO dto) {
        Catalog catalog = new Catalog();
        catalog.setName(dto.getName());
        catalog.setDescription(dto.getDescription());

        return catalog;
    }

    private void buildUpdateRules(Catalog catalog, CatalogRequestDTO dto) {
        catalog.setName(dto.getName());
        catalog.setDescription(dto.getDescription());
    }
}
