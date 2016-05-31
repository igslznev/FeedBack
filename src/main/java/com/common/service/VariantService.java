package com.common.service;


import com.common.model.Variant;

import java.util.List;

public interface VariantService {

    Variant addVariant(Variant variant);
    void delete(Long id);
    Variant getById(Long id);
    Variant editVariant(Variant variant);
    List<Variant> getAll();
    List<Variant> findByIdQuestion(Long id);
}
