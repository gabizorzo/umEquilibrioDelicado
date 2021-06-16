public class Q1 {
    public static void main(String[] args){
        // ArvoreBinaria b = new ArvoreBinaria();
        // ArvoreBinaria c = new ArvoreBinaria();
        // ArvoreBinaria d = new ArvoreBinaria();
        

        // b.addRoot(10);
        // b.addLeft(9, 10);
        // b.addRight(8, 10);
        // b.addLeft(7, 9);
        // b.addRight(6, 9);
        // b.addLeft(5, 8);
        // b.addRight(4, 8);

        // b.printTree();

        // System.out.println(b.isHeap());

        // c.addRoot(1);
        // c.addLeft(10, 1);
        // c.addRight(8, 1);
        // c.addLeft(7, 10);
        // c.addRight(6, 10);
        // c.addLeft(5, 8);
        // c.addRight(4, 8);
        // c.addLeft(1, 4);
        // c.addRight(1, 4);

        // c.printTree();

        // System.out.println(c.isHeap());

        // d.addRoot(5);
        // d.addLeft(4, 5);
        // d.addRight(3, 5);
        // d.addLeft(0, 4);
        // d.addRight(7, 4);
        // d.addLeft(1, 3);
        // d.addRight(0, 3);

        // d.printTree();

        // System.out.println(d.isHeap());

        int v1[] = {4,5,6,0,0,0};
        int a = 3;
        int b = 3;
        int v2[] = {1,2,3};

        int j = b-1;
        int k = a-1; // inicia no fim de a
        int l = a+b-1; //inicia no fim do vetor v1

        while (l>=0){ // l depende de a+b, tendo notação O(a+b)
            if ( k < 0 ){ // se todos os elementos de a já estão na posição correta em v1
                v1[l] = v2[j];
                j--;
            } else if (j >= 0 ){ // se ainda tem elementos em v2 que não foram adicionados em v1
                if(v2[j]>v1[k]){
                    v1[l]=v2[j];
                    j--;
                } else {
                    v1[l]=v1[k];
                    k--;
                }
            }
            l--;
        }
        
        for(int m = 0; m<a+b; m++){
            System.out.print(" " + v1[m]);
        }

        System.out.println();

    // for (int i = a-1; i >= 0; i--){ // O(a)
        //     v1[i+b] = v1[i]; 
        // }

        // int j = 0;
        // int k = b; // inicia em b
        // int l = 0; //inicia em zero

        // while (l<(a+b)){
        //     if ( k >= a+b ){ // se todos os elementos de a já estão na posição correta em v1
        //         v1[l] = v2[j];
        //         j++;
        //     } else if (j < b ){ // se ainda tem elementos em v2 que não foram adicionados em v1
        //         if(v2[j]<v1[k]){
        //             v1[l]=v2[j];
        //             j++;
        //         } else {
        //             v1[l]=v1[k];
        //             k++;
        //         }
        //     }
        //     l++;
        // }
            


    
    }

    


    
}
