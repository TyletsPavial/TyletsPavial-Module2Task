

import BracketChecker.*;
import BracketPair.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BracketPairFactory<BracketPair> bPFactory = BracketPair::new;
        BracketCheckerInterface bracketChecker = new BracketChecker(bPFactory.create('(',')'),
                bPFactory.create('[',']'), bPFactory.create('{','}'),
                bPFactory.create('<','>'));
        Scanner in = new Scanner(System.in);

        System.out.print("Enter string to check: ");
        System.out.println(bracketChecker.checkString(in.next()));
    }

}
