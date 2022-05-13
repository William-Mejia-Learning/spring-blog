package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(path = "/add100To/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOneHundred(@PathVariable int number){
        return number + " + 100 = " + (number + 100);
    }

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addNum(@PathVariable int num1, @PathVariable int num2){
        return  num1 +" + " + num2 + " = " + (num1 + num2);
    }

    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subNum(@PathVariable int num1, @PathVariable int num2){
        return  num1 +" - " + num2 + " = " + (num1 - num2);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplyNum(@PathVariable int num1, @PathVariable int num2){
        return  num1 +" x " + num2 + " = " + (num1 * num2);
    }

    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public String divideNum(@PathVariable int num1, @PathVariable int num2){
        return  num1 +" / " + num2 + " = " + (num1 / num2);
    }
}
