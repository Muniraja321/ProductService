package net.javaguides.productservices;

import org.springframework.web.bind.annotation.ExceptionHandler;



public class NotFoundException extends Exception{
   public NotFoundException(String message){

       super(message);

   }
}
