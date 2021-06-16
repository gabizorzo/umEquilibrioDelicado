public class ArvoreBinaria {

    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        public Integer element;
        public Boolean isBalanced;
        public Integer effort;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
            isBalanced = false;
            effort = 0;
        }
    }

    private int count; //contagem do número de nodos
    private Node root; //referência para o nodo raiz

    public ArvoreBinaria() {
        count = 0;
        root = null;
    }

    public void printTree(){
        printTree(root, "");
    }

    private void printTree(Node n, String space) {

        if (n != null){
        printTree(n.left, space+"      ");
        printTree(n.right, space+"      ");

       
            System.out.println(space + n.element);
       
        
        }
    }

    public void addRoot(Integer element) {
        Node n = new Node(element);
        root = n;
    }

    public boolean addLeft(Integer element, Integer elemPai) {
        Node aux = searchNodeRef(elemPai, root);
        if (aux==null) // se nao encontrou elemPai na arvore
            return false;
        if (aux.left != null) // se ja tem filho a esquerda
            return false;
        
        // Se encontrou elemPai e ele nao tem filho a esquerda
        // insere element como filho a esquerda de elemPai
        Node n = new Node(element);
        n.father = aux;
        aux.left = n;
        count++;
        return true;
    }

    public boolean addRight(Integer element, Integer elemPai) {
        Node aux = searchNodeRef(elemPai, root);
        if (aux==null) // se nao encontrou elemPai na arvore
            return false;
        if (aux.right != null) // se ja tem filho a direita
            return false;
        
        // Se encontrou elemPai e ele nao tem filho a direita
        // insere element como filho a direita de elemPai
        Node n = new Node(element);
        n.father = aux;
        aux.right = n;
        count++;
        return true;        
    }

    private Node searchNodeRef(Integer element, Node target) {
        if (target == null)
            return null;
        //Pre: raiz, esq, dir
        if (target.element.equals(element)) { // visita a raiz
            return target;
        }
        Node aux = searchNodeRef(element, target.left); // visita esq
        if (aux == null) {
            aux = searchNodeRef(element, target.right); // visita dir
        }
        return aux;
    }


    // public LinkedList positionsWidth() {
    //     Queue<Node> fila = new Queue<>();
    //     Node atual = null;
    //     LinkedList res = new LinkedList();
    //     if (root != null) {
    //         fila.enqueue(root);
    //         while (!fila.isEmpty()) {
    //             atual = fila.dequeue();
    //             if (atual.left != null) {
    //                 fila.enqueue(atual.left);
    //             }
    //             if (atual.right != null) {
    //                 fila.enqueue(atual.right);
    //             }
    //             res.add(atual.element);
    //         }
    //     }
    //     return res;
    // }

    boolean isHeap = true;

    public boolean isHeap() {
        return isHeap(root);
    }
  
    public boolean isHeap(Node n) {
      if (n != null) {
        isHeap(n.left);
        isHeap(n.right);
        if((n.left != null || n.right!= null) && isHeap != false){
          if(!(n.left.element <= n.element && n.right.element <= n.element)){
            isHeap = false;
          }else{
            isHeap = true;
          }
        }
        //System.out.println("IS HEAP: "+ isHeap);
        return isHeap;
      }
      return false;
    }
   
}