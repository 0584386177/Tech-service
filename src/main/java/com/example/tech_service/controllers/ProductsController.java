package com.example.tech_service.controllers;

import com.example.tech_service.models.Product;
import com.example.tech_service.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductsController {

    @Autowired
    private ProductsRepository repo;

    @GetMapping("/")
    public String homeProductList(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "products/index";

    }

    @GetMapping("/product")
    public String productProductList(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "products/product";

    }

    @GetMapping("/contact")
    public String contactProductList(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "products/contact";
    }

    @GetMapping("/profile")
    public String profileProductList(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "products/profile";
    }   

    @GetMapping("/cart")
    public String cartProductList(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "products/cart";
    }
    // Hiển thị danh sách sản phẩm
//    @GetMapping
//    public String listProducts(Model model) {
//        model.addAttribute("products", repo.getAllProducts());
//        return "admin/products";
//    }


}
