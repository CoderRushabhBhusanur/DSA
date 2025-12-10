package Stack_Example;

import java.util.Scanner;
import java.util.Stack;

public class String_Reversal
{
    public static void main(String[] args) {
        Stack<Character> obj = new Stack<>();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter word:");
        String word = in.next();
        String rword = "";

        // use loop to add one character at a time in stack
        for (int i = 0; i < word.length(); i++) {
            obj.push(word.charAt(i));
        }
        
        //or
        //for(char c:word.toCharArray())
//        	obj.push(c);

        // till stack not empty pop and copy poped to rword '+'
        while (!obj.empty()) {
            rword = rword + obj.pop();
        }
        
        //or
        //while(!obj.empty())
//        {
//        	rword = rword+obj.pop();
//        }

        System.out.println("Reversed word: " + rword);
    }
}
