import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Index i = new Index("C:\\Users\\alena\\IdeaProjects\\" +
                "Practice1.Vocabulary\\Collection");
        Tree t = new Tree(i);

        PermutIndex pi = new PermutIndex(i);

        KIndex k = new KIndex(i);

        Scanner in = new Scanner(System.in);

        System.out.println("\n1.Show tree;\n2.Show permut. index;\n3.Show K index;\n4.Search tree" +
                ";\n5.Search PI;\n6.Search KI;\n-1.Exit\n");
        int i1= in.nextInt();

        while(i1!=-1) {
            switch (i1) {
                case 1:
                    System.out.println(t);
                    break;
                case 2:
                    System.out.println(pi);
                    break;
                case 3:
                    System.out.println(k);
                    break;
                case 4:
                    System.out.println("Enter:");
                    in.nextLine();
                    String input = in.nextLine();
                    System.out.println(t.search(input));
                    break;
                case 5:
                    System.out.println("Enter:");
                    in.nextLine();
                    input = in.nextLine();
                    System.out.println(pi.search(input));
                    break;
                case 6:
                    System.out.println("Enter:");
                    in.nextLine();
                    input = in.nextLine();
                    System.out.println(k.search(input));
                    break;
                default:
                    System.out.println("Wrong format");
            }
            System.out.println("\n1.Show tree;\n2.Show permut. index;\n3.Show K index;\n4.Search tree" +
                    ";\n5.Search PI;\n6.Search KI;\n-1.Exit\n");
            i1 = in.nextInt();
        }
    }

}
