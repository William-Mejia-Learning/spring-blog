package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String addNum(@PathVariable double num1, @PathVariable double num2){
        return  num1 +" + " + num2 + " = " + (num1 + num2);
    }

    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subNum(@PathVariable double num1, @PathVariable double num2){
        return  num1 +" - " + num2 + " = " + (num1 - num2);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplyNum(@PathVariable double num1, @PathVariable double num2){
        return  num1 +" x " + num2 + " = " + (num1 * num2);
    }

    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public String divideNum(@PathVariable double num1, @PathVariable double num2){
        return  num1 +" / " + num2 + " = " + (num1 / num2);
    }


    @GetMapping("math")
    public String math() {
        return "math/index";
    }

    @PostMapping("/math")
    public String doMath(
        @RequestParam(name = "inputA") double inputA,
        @RequestParam(name="inputB") double inputB,
        @RequestParam(name="operation") String operation,
        Model model
    ){
        double total = 0L;
        switch (operation){
            case "add":
                total = inputA + inputB;
            case "subtract":
                total = inputA - inputB;
            case "multiply":
                total = inputA * inputB;
            case "divide":
                total = inputA / inputB;
        }

        model.addAttribute("total", total);

        return "math/index";
    }
}
