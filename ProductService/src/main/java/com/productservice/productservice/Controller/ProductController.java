package com.productservice.productservice.Controller;

import com.productservice.productservice.services.DTO.CreateProductDto;
import com.productservice.productservice.services.DTO.GetAllProductDto;
import com.productservice.productservice.services.DTO.ProductDto;
import com.productservice.productservice.services.DTO.UpdateProductDto;
import com.productservice.productservice.services.abstracts.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/product")

public class ProductController {
    private ProductService productService;

    @GetMapping
    public ResponseEntity findAllProducts(){
        log.info("* fetch all products");
        List<GetAllProductDto> getAllProductDtos = this.productService.findAll();
        return ResponseEntity.ok(getAllProductDtos);
    }
    /*@GetMapping("/{productid}")
    public ResponseEntity findById(@PathVariable("productid")  Long id){
        log.info("fetch product by id");
         ProductDto productDto = this.productService.findById(id);
         return ResponseEntity.ok(productDto);
    }*/
    @PostMapping
    public ResponseEntity addProduct(@RequestBody @Valid CreateProductDto createProductDto){
        log.info("add product");
        this.productService.add(createProductDto);
        return ResponseEntity.ok("Product added system");
    }
    @PutMapping
    public ResponseEntity Update(@RequestBody @Valid UpdateProductDto updateProductDto){
        log.info("update product");
        this.productService.update(updateProductDto);
        return ResponseEntity.ok("Update product");
    }
    @PutMapping("/{productid}")
    public ResponseEntity update(@PathVariable("porductid") @NotBlank(message = "input must not be null") Long id,@RequestBody @Valid UpdateProductDto updateProductDto){
        log.info("product deleted by id");
        this.productService.updateById(id,updateProductDto);
        return ResponseEntity.ok("update product by id");
    }
    @DeleteMapping("/{productid}")
    public ResponseEntity delete(@PathVariable("productid") Long id){
        log.info("product deleted");
        this.productService.delete(id);
        return ResponseEntity.ok("product deleted");
    }
    @GetMapping("/{itemsku}")
    public ResponseEntity findByItemSku(@PathVariable("itemsku")  Long itemsku){
        log.info("fetch product by itemsku");
        ProductDto productDto = this.productService.findByItemSku(itemsku);
        return ResponseEntity.ok(productDto);
    }

}
