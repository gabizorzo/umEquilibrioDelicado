import java.io.IOException;
import java.util.List;

public class Efforts {
    public static void Tree() throws IOException {
        List<String> file = FileReaderWithScanner.scan();
        BinaryTree b = new BinaryTree();


       // Adiciona o nodo raíz e seus filhos
       String[] line = file.get(0).split(" ");
       b.addRoot(line[0]);
       b.addLeft(line[1], line[0]);
       b.addRight(line[2], line[0]);

       // Adiciona os próximos nodos se existirem
        for (int i = 1; i < file.size(); i++){
            line = file.get(i).split(" ");
            b.addLeft(line[1], line[0]);
            b.addRight(line[2], line[0]);
        }

        long total = 0;
        for(int j=0; j<1000; j++) {
            long start = System.nanoTime();
            b.treeEfforts();
            long finish = System.nanoTime();
            long timeElapsed = finish-start;
            total += timeElapsed;
        }
        
        System.out.println("Número do nodos balanceados = " + b.isBalanced());
        System.out.println("A solução levou (nanosegundos): " + total/1000);
        b.printTree();
    }

    
    public static void main(String[] args) throws IOException {
        Tree();
      
    }
}
