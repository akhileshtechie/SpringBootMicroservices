package com.coursecube.spring.service;
import java.io.File;
/*
* @Author : Akhilesh Bhagat
* @company : Java Learning Center
* */
public interface MailService {
 public void sendMail(String from,String to,String subject,String body) ;
 public void sendMail(String from,String to,String subject,String body,File file) ;
} 