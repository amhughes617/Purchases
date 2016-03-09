package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Created by alexanderhughes on 3/9/16.
 */
@Controller
public class PurchaseController {
    @Autowired
    PurchaseRepository purchases;
    @Autowired
    CustomerRepository customers;
    @PostConstruct
    public void init() throws FileNotFoundException {
        if (customers.count() == 0) {
            File f = new File("customers.csv");
            Scanner fileScanner = new Scanner(f);
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String[] columns = fileScanner.nextLine().split(",");
                Customer customer = new Customer(columns[0], columns[1]);
                customers.save(customer);
            }
        }
        if (purchases.count() == 0) {//just dont want to keep adding the data to the database over and over again
            File f = new File("purchases.csv");
            Scanner fileScanner = new Scanner(f);
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String[] columns = fileScanner.nextLine().split(",");
                Purchase purchase = new Purchase(customers.findOne(Integer.valueOf(columns[0])), LocalDateTime.parse(columns[1]), columns[2], Integer.valueOf(columns[3]), columns[4]);
                purchases.save(purchase);
            }
        }
    }
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category) {
        if (category != null) {
            model.addAttribute("purchases", purchases.findByCategoryIgnoreCase(category));
        }
        else {
            model.addAttribute("purchases", purchases.findAll());
        }
        return "home";
    }
}
