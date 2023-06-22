/* Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' 
where:
1)- '?' Matches any single character.
2)- '*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
* Eg 1 :    s = "aa"         p = "a"       Output = false
* Eg 2 :    s = "aa"         p = "*"       Output = true 
* Eg 3 :    s = "bc"         p = "?a"      Output = false
* Eg 4 :    s = "abd"        p = "a?d"     Output = true 
*/
import java.util.*;
public class Wildcard
{
      public boolean WildcardMatch(String input, String output)
      {
            int check = 0;       //*  Variable declaration -> O(1)
            for(int i = 0; i < output.length(); i++)     //! Checking the Output String -> O(N)
            {
                  if(output.charAt(i) == '*')    // if output string contains '*'...
                        check++;
            }
            if((check == 0) && (input.length() != output.length()))
                  return false;    // If output string does not contains '*' and their lengths are not equal...
            for(int i = output.length() - 1, j = input.length() - 1; i > -1; i--, j--)   //! Comparison -> O(N)
            {
                  if(output.charAt(i) == '*')    // '*' matches entire subsequence...
                        return true;
                  else if(output.charAt(i) == '?')    // '?' matches at a single index...
                        continue;
                  else if(input.charAt(j) != output.charAt(i))
                        return false;
            }
            return true;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            String s, p;
            System.out.print("Enter input string : ");
            s = sc.next();
            System.out.print("Enter output string : ");
            p = sc.next();
            Wildcard wildcard = new Wildcard();      // Object creation...
            System.out.println("Wildcard Matched : "+wildcard.WildcardMatch(s, p));    // Function calling...
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(1)