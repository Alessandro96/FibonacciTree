import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f;
        Node<Integer> tree = new Node<>();

        System.out.print("Inserire il passo della sequenza di fibonacci che si vuole calcolare: ");
        f = scanner.nextInt();
        System.out.println("L'element o numero " + f + " della sequenza di fibonacci è: " + fibonacciTree(f, tree));
        binaryTreePrint(tree);
    }

    static void afjk(){
        String s = "111";
        s = String.format("%" + 4 + "s", s).replace(" ", "0");
        System.out.println(s);
    }

    static Integer fibonacciTree(int n, Node<Integer> tree){
        if(n<2){
            tree.setData((Integer) n);
            tree.setRSon(null);
            tree.setLSon(null);
            return tree.getData();
        }
        Node<Integer> lSon = new Node<>();
        lSon.setParent(tree);
        Node<Integer> rSon = new Node<>();
        rSon.setParent(tree);
        lSon.setData(fibonacciTree(n-1, lSon));
        rSon.setData(fibonacciTree(n-2, rSon));
        tree.setLSon(lSon);
        tree.setRSon(rSon);
        tree.setData(lSon.getData()+rSon.getData());
        return tree.getData();
    }

    static void binaryTreePrint(Node<Integer> tree){
        int k;
        int inverse = 1, h;
        Node<Integer> node = tree;

        h = rootHeight(node);

        rootPrint(node, h);

        while(inverse<=h) {
            for (int j = (int) Math.pow(2, inverse) - 1; j >= 0; j--) {
                String s = "";
                k = j;
                for (int i = 1; i <= inverse; i++) {
                    if (k > 0) {
                        s = (k % 2) + s;
                        k /= 2;
                    }
                    else break;
                }
                s = String.format("%" + (inverse) + "s", s).replace(" ", "0");
                for(int z=0; z<inverse; z++){
                    if(s.charAt(z) == '1'){
                        if(node.getLSon() == null) {
                            node = new Node<>(null, null, node, -1);
                            break;
                        }
                        node = node.getLSon();
                    }
                    else if (s.charAt(z) == '0'){
                        if(node.getRSon() == null) {
                            node = new Node<>(null, null, node, -1);
                            break;
                        }
                        node = node.getRSon();
                    }
                    else{
                        System.out.println("\n\nerror\n\n");
                        return;
                    }
                }
                String print;
                if(node.getData() == -1){
                    print = String.format("%" + ((int) Math.pow(2, ((h) - inverse))) + "s", "*");
                }
                else {
                    print = String.format("%" + ((int) Math.pow(2, ((h) - inverse))) + "d", node.getData());
                }
                String space = String.format("%" + ((int) Math.pow(2, ((h) - inverse))) + "s", "|");
                System.out.print(print);
                System.out.print(space);
                node = tree;
            }
            System.out.println();
            inverse++;
        }
    }

    static int rootHeight(Node<Integer> tree){
        int h = 0;

        while(tree.getLSon()!=null){
            h++;
            tree = tree.getLSon();
        }
        System.out.println("L'altezza dell'albero è: " + h);
        return h;
    }

    static void rootPrint(Node<Integer> tree, int h){
        String filling = String.format("%" + (int) Math.pow(2, h)*2 + "s", " ").replace(" ", "-");
        String printRoot = String.format("%" + (int) Math.pow(2, h) + "d", tree.getData());
        String rootSpace = String.format("%" + (int) Math.pow(2, h) + "s", "|");
        System.out.println(filling);
        System.out.print(printRoot);
        System.out.println(rootSpace);
    }
}