import java.util.Scanner;

import parses.Parse;
import structures.DoublyLinkedList;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Parse parse = new Parse();

        System.out.println("Digite o primeiro número: ");
        long n1 = scanner.nextLong();

        DoublyLinkedList list1 = parse.parseList(n1);
        System.out.println(list1);

        System.out.println("\nDigite o segundo número: ");
        long n2 = scanner.nextLong();

        DoublyLinkedList list2 = parse.parseList(n2);
        System.out.println(list2);

        System.out.println("O produto é igual a: \n");
        System.out.println(parse.multiply(n1, n1));
        
        
    }
}
