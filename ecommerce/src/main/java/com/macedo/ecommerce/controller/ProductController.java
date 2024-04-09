package com.macedo.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.macedo.ecommerce.model.Category;
import com.macedo.ecommerce.model.Product;
import com.macedo.ecommerce.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService productService;    


    @RequestMapping("/showForm")
    public String showFormProduct(Model model){

        Product product = new Product();

        model.addAttribute("product", product);
        model.addAttribute("categorys", Category.values());
        return "product/formProduct";
    }

    @RequestMapping("/addProduct")
    public String showFormProduct(
        @ModelAttribute("product") Product product,  
        Model model){
        productService.saveProduct(product);
        model.addAttribute("product", product);
        return "redirect:/product/getListaProducts";
    }

    @RequestMapping("/getListaProducts")
    public String showListaProduct(Model model){
        List<Product> products = productService.getProducts();
        model.addAttribute("products",products);
        return "product/listaProducts";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        Product deleteProduct = productService.getProductById(id);
        if(deleteProduct != null)
            productService.deleteProduct(deleteProduct);
        return "redirect:/product/getListaProducts";
    }
}
