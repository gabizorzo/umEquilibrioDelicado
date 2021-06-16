public class BinaryTree {

    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        public String element;
        public Boolean isBalanced;
        public Integer effort;

        public Node(String element) {
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

    public BinaryTree() {
        count = 0;
        root = null;
    }


    public void treeEfforts(){
        treeEfforts(root);
    }

    private int treeEfforts(Node n) {

        if (n != null){
            int leftEffort = treeEfforts(n.left);
            int rightEffort = treeEfforts(n.right);
            
            // para os nodos folha, transforma o valor lido do arquivo em seu esforço
            if (!n.element.startsWith("X")){
                n.effort = Integer.parseInt(n.element);
            } else {
                // para os demais nodos, o esforço é a soma dos esforços de seus filhos
                n.effort = leftEffort + rightEffort;
                n.isBalanced = (leftEffort == rightEffort);
            }


            return n.effort;
        }
        else return 0;

    }

    public int isBalanced(){
        return isBalanced(root);
    }

    private int isBalanced(Node n) {
    
        if (n != null){
            int leftBalance = isBalanced(n.left);
            int rightBalance = isBalanced(n.right);
            if (n.isBalanced){
                return leftBalance+rightBalance+1;
            } else {
                return leftBalance+rightBalance;
            }
        } 

        return 0;
    }

    public void printTree(){
        printTree(root, "");
    }

    private void printTree(Node n, String space) {

        if (n != null){
        printTree(n.left, space+"      ");
        printTree(n.right, space+"      ");

        if (!n.element.startsWith("X")){
            System.out.println(space + n.element+"("+n.effort+")" );
        } else {
            System.out.println(space + n.element+"("+n.effort+")"+ n.isBalanced );
        }
        
        }
    }

    public void addRoot(String element) {
        Node n = new Node(element);
        root = n;
    }

    public boolean addLeft(String element, String elemPai) {
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

    public boolean addRight(String element, String elemPai) {
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

    private Node searchNodeRef(String element, Node target) {
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

   
}