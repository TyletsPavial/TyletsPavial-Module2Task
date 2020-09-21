package BracketChecker;

import BracketPair.BracketPair;

import java.util.*;

public class BracketChecker implements BracketCheckerInterface {
    private BracketPair[] brackets;

    public BracketChecker(BracketPair... brackets) {
        this.brackets = brackets;
    }

    public void setBrackets(BracketPair[] brackets) {
        this.brackets = brackets;
    }

    public BracketPair[] getBrackets() {
        return brackets;
    }

    public Set<String> createSubstrings(String s){
        Set<String> substrings = new HashSet<>();
        int sum;
        int aStart;
        boolean charIsBracketFlag;
        boolean stringContainsBracket = false;
        for(BracketPair bP: brackets){
            aStart = 0;
            sum = 0;
            for(int c = 0; c < s.length(); c++){
                if(s.charAt(c) == bP.getOpener()){
                    sum++;
                    charIsBracketFlag = true;
                    stringContainsBracket = true;
                }
                else if(s.charAt(c) == bP.getCloser()){
                    sum--;
                    charIsBracketFlag = true;
                    stringContainsBracket = true;
                }
                else charIsBracketFlag = false;
                if(sum == 1 && charIsBracketFlag){
                    aStart = c;
                }
                if(charIsBracketFlag && sum == 0){
                        substrings.add(s.substring(aStart ,c + 1));
                    aStart = c;
                }
            }
        }
        if(substrings.size()== 0 && stringContainsBracket){
            substrings.add(s);
        }
        return substrings;
    }
    public boolean checkString(String s){
        Set<String> strings = this.createSubstrings(s);
        if(strings.size() == 0){
            System.out.println("Your string don't contain any bracket!");
            return false;
        }
        int sum = 0;
        for(BracketPair bp: brackets){
            for(String str: strings){
                for(int c = 0; c < str.length(); c++){
                    if(bp.getOpener() == str.charAt(c)){
                        sum++;
                    }
                    else if (bp.getCloser() == str.charAt(c)){
                        sum--;
                    }
                    if(sum < 0){
                        return false;
                    }
                }
                if (sum != 0){
                    return false;
                }
            }
        }
        return true;
    }
}
