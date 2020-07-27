package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.entity.Books;
import com.example.demo.models.entity.BooksCreationDto;
import com.example.demo.models.service.IBooksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("books")
public class BooksController {
    @Autowired
    private IBooksService bookService;

    @RequestMapping("/")
    public String index(Model model) {
    	return "index";
    }
    
    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/allBooks";
    }

    @RequestMapping("/create")
    public String showCreateForm(Model model) {
        BooksCreationDto booksForm = new BooksCreationDto();

        for (int i = 0; i < 3; i++) {
            booksForm.addBook(new Books());
        }
        
        model.addAttribute("form", booksForm);
        return "books/createBooksForm";
    }

    @PostMapping("/save")
    public String saveBooks(@ModelAttribute BooksCreationDto form, Model model) {
        bookService.saveAll(form.getBooks());

        model.addAttribute("books", bookService.findAll());
        return "redirect:/all";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        List<Books> books = new ArrayList<>();
        BooksCreationDto bookscreationdto = new BooksCreationDto();
        bookscreationdto.setBooks(books);
        bookService.findAll().iterator().forEachRemaining(books::add);

        model.addAttribute("form", bookscreationdto);
        return "books/editBooksForm";
    }
    
    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable("id") Long id, Model model) {
    	bookService.delete(id);
    	return "-1";
    }
}