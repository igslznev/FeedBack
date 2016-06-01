package com.common.service.impl;

import com.common.model.Variant;
import com.common.repository.VariantRepository;
import com.common.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("VariantService")
public class VariantServiceImpl implements VariantService {

    @Autowired
    private VariantRepository variantRepository;

    @Override
    public Variant addVariant(Variant variant) {
        return variantRepository.saveAndFlush(variant);
    }

    @Override
    public void delete(Long id) {
        variantRepository.delete(id);
    }

    @Override
    public Variant getById(Long id) {
        return variantRepository.findOne(id);
    }

    @Override
    public Variant editVariant(Variant variant) {
        return variantRepository.saveAndFlush(variant);
    }

    @Override
    public List<Variant> getAll() {
        return variantRepository.findAll();
    }

    @Override
    public List<Variant> findByIdQuestion(Long id) {
        return variantRepository.findByQuestion_IdQuestion(id);
    }


}
