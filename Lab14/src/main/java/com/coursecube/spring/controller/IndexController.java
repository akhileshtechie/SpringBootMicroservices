package com.coursecube.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
* @Author : Akhilesh Bhagat
* @company : Java Learning Center
* */
@Controller
public class IndexController {
 @GetMapping("/")
 public String showIndexPage() {
 System.out.println("---------showIndexPage---------");
 return "index";
 }
} 
