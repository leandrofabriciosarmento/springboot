package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductRecordDTO;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    private ProductController productController;
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        productRepository = mock(ProductRepository.class);
        productController = new ProductController(productRepository);
    }

    @Test
    public void testGetProducts() {
        ProductModel productModel = new ProductModel();
        when(productRepository.findAll()).thenReturn(Collections.singletonList(productModel));

        ResponseEntity<List<ProductModel>> response = productController.getProducts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(productModel, response.getBody().get(0));
    }

    @Test
    public void testGetProduct() {
        UUID id = UUID.randomUUID();
        ProductModel productModel = new ProductModel();
        when(productRepository.findById(id)).thenReturn(Optional.of(productModel));

        ResponseEntity<Object> response = productController.getProduct(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productModel, response.getBody());
    }

    @Test
    public void testSaveProduct() {
        ProductRecordDTO productRecordDTO = new ProductRecordDTO("Coca-Cola", BigDecimal.ONE);
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDTO, productModel);
        when(productRepository.save(any(ProductModel.class))).thenReturn(productModel);

        ResponseEntity<ProductModel> response = productController.savePoduct(productRecordDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(productModel, response.getBody());
    }

    @Test
    public void testUpdateProduct() {
        UUID id = UUID.randomUUID();
        ProductRecordDTO productRecordDTO = new ProductRecordDTO("Coca-Cola", BigDecimal.ONE);
        ProductModel productModel = new ProductModel();
        when(productRepository.findById(id)).thenReturn(Optional.of(productModel));
        when(productRepository.save(any(ProductModel.class))).thenReturn(productModel);

        ResponseEntity<Object> response = productController.updateProduct(id, productRecordDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productModel, response.getBody());
    }

    @Test
    public void testDeleteProduct() {
        UUID id = UUID.randomUUID();
        ProductModel productModel = new ProductModel();
        when(productRepository.findById(id)).thenReturn(Optional.of(productModel));
        doNothing().when(productRepository).delete(productModel);

        ResponseEntity<Object> response = productController.deleteProduct(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Produto excluído", response.getBody());
    }
}
