package com.example.tech_service.controllers;

import com.example.tech_service.models.Product;
import com.example.tech_service.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

        @Autowired
    private ProductsService productService;

    // Trang chính của admin (Được truy cập qua /admin)
    @GetMapping("")
    public String dashboard(Model model) {
        return "admin/index";  // Đảm bảo trang này có tồn tại trong thư mục templates
    }
    // Hiển thị danh sách sản phẩm
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "admin/products";
    }

    // Trang thêm sản phẩm mới
    @GetMapping("/new")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "admin/editProduct";
    }

    // Xử lý lưu sản phẩm mới hoặc sửa sản phẩm
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin/products";  // Quay lại trang danh sách sản phẩm
    }

    // Trang chỉnh sửa sản phẩm
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        return "admin/editProduct";
    }

    // Xử lý xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/products";  // Quay lại trang danh sách sản phẩm
    }
}
