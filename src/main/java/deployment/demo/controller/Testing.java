package deployment.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class Testing {

    @GetMapping("/{operation}/{firstNumber}/{secondNumber}")
    public float addNumber(@PathVariable("operation") String operation,@PathVariable("firstNumber") float firstNumber,@PathVariable("secondNumber") float secondNumber){
        switch (operation){
            case "add":
                return firstNumber+secondNumber;
            case "subtract" :
                return firstNumber-secondNumber;
            case "multiply" :
                return firstNumber*secondNumber;
            case "divide" :
                return firstNumber/secondNumber;
            default:
                return 0;
        }
    }

    @GetMapping("isPalindrome/{number}")
    public boolean isPalindrome(@PathVariable("number") int number){
        int temp;
        int rem;
        int rev = 0;
        temp=number;
        while(temp!=0){
            rem=temp%10;
            rev=rev*10+rem;
            temp=temp/10;
        }
        return rev == number;
    }

    @GetMapping("fact/{number}")
    public int factorial(@PathVariable("number") int number){
        int fact=1;
        if(number==0){return 1;}
        for(int i=2;i<=number;i++){
            fact=fact*i;
        }
        return fact;
    }


}
