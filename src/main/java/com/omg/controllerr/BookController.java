package com.omg.controllerr;

import com.omg.entity.Book;
import com.omg.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "booksList";
    }

    @GetMapping("/book/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "showBook";
    }

    @GetMapping("/book2/{id}")
    public @ResponseBody
    Book getById2(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return bookService.getById(id);
    }

    @GetMapping("/addBook")
    public String createBookPage() {
        return "createBook";
    }

    @PostMapping("/UpdateBook")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.update(book);
        return "redirect:/book/" + book.getId();
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book) throws Exception {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "editBook";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/books";
    }

}
