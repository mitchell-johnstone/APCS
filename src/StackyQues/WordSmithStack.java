package StackyQues;

import java.util.Stack; // utility library for Stack
import java.util.Scanner;
public class WordSmithStack
{
    public static void main (String[] args )
    {
        Scanner scan = new Scanner (System.in);
        Stack <Character> word = new Stack<Character> (); //construct Stack of characters
        Stack <Character> phrase = new Stack<Character> ();
        for (int x = 0; x< 5; x++ )
        { System.out.println(" Enter character ");
            String letter = scan.next();
            word.push (letter.charAt(0)); // push entered characters onto Stack
        }
        System.out.println( word);
        System.out.println();
        System.out.println( word.pop() ); // pop off characters
        System.out.println( word.pop() );
        System.out.println( word);
        System.out.println( word.peek() ); // peek at top of Stack
        scan.nextLine();
        System.out.println( " Enter a phrase backwards....example" );
        System.out.println( "eeS topS nuR for the phrase See Spot Run" );
        String message = scan.nextLine();
        int index = 0;
        while (index < message.length() )
        { // traverse message character by character
            while ( index < message.length() && message.charAt(index) != ' ')
            { // push characters onto stack until 'space' located
                phrase.push ( message.charAt(index));
                index++;
            }
// reversing characters for each 'word'
            while ( !phrase.isEmpty() )
                System.out.print( phrase.pop() ); // pop offcharacters until empty
            System.out.print(" ");
            index++;
        }
    }

}
