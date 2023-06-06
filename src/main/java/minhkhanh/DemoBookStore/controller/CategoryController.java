package minhkhanh.DemoBookStore.controller;

import minhkhanh.DemoBookStore.enitity.Category;
import minhkhanh.DemoBookStore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllCategory(Model model)
    {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        model.addAttribute("name","categories");
        return "category/list";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model){
        model.addAttribute("category",new Category());
        return "category/add";
    }


    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors())
        {

            return "category/add";
        }
        categoryService.createCategory(category);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") long id, Model model){
        Category editCate = categoryService.getCategoryById(id);
        if(editCate != null){
            model.addAttribute("category", editCate);
            return "category/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("category")Category updateCate, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("category", categoryService.getAllCategories());
            return "category/edit";
        }
        categoryService.getAllCategories().stream()
                .filter(category -> category.getId() == updateCate.getId())
                .findFirst()
                .ifPresent(category -> {

                    categoryService.updateCategory(category);
                });
        return "redirect:/category";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id){
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }
}
