package com.arrayProducts.arrayProductos.controller;

import com.arrayProducts.arrayProductos.handle.ProductError;
import com.arrayProducts.arrayProductos.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private List<Product> productList=new ArrayList<Product>();

    //TODO agregar manejo de error en caso de lsita vacia.

    @GetMapping
    public List<Product> getProductList() throws ProductError {
        if(productList.isEmpty()){
            throw new ProductError("No hay productos cargados");
        }
        return productList;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id)throws ProductError{
        for(Product product: productList){
            if(product.getId() == id){
                return product;
            }
        }
        throw new ProductError("No existe un producto con ese id");
        //var productFiltered = productList.stream().filter(product -> Objects.equals(product.getId(),id));

    }

    @PostMapping
    public String addProduct(@RequestBody Map<String,String> requestBody){
        String title = requestBody.get("title");
        String price = requestBody.get("price");
        Product product = new Product(title,Integer.parseInt(price));
        productList.add(product);
        product.setId(productList.size());
        return "Se agrego un nuevo producto con id :" + productList.size();
    }


}
