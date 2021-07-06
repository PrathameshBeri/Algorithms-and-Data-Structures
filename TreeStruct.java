class TreeNode<T extends Comparable<T>>{

     T data;
     TreeNode leftNode;
     TreeNode rightNode;


    public void insert(T nodeData){

        if(nodeData.compareTo(data)> 0){
            if(this.rightNode == null){

                this.rightNode = new TreeNode(nodeData);
            }
            else{

                this.rightNode.insert(nodeData);
            }
        }else if(nodeData.compareTo(data)<0){

            if(this.leftNode == null){

                this.leftNode = new TreeNode(nodeData);
            }
            else{

                this.leftNode.insert(nodeData);
            }
        }
    }

    public TreeNode(T data){

        this.data = data;
        this.leftNode = this.rightNode = null;
    }


     public T getNode(TreeNode<T> node){

        
            return node.data;
        
    }

    public TreeNode getLeftNode(TreeNode node){

        if(!node.leftNode.equals(null)){

            return node.leftNode;
        }else{
            return null;
        }
    }

    public TreeNode getRightNode(TreeNode node){

        if(!node.rightNode.equals(null)){

            return node.rightNode;
        }else{
            return null;
        }
    }

}


class TreeStruct<T extends Comparable<T>>{

    private TreeNode<T> root;

    public TreeStruct(){
        root = null;
    }



    public void insertNode(T node){
        if(this.root == null){
            this.root = new TreeNode(node);
        }
        else{
            root.insert(node);
        }
    }

    public void inOrderTraversal(){

        inOrderTraversalHelper(root);

    }

    private void inOrderTraversalHelper(TreeNode<T> helper){

        if(helper == null){

            return;
        }

        inOrderTraversalHelper(helper.leftNode);
        System.out.println(helper.data);
        inOrderTraversalHelper(helper.rightNode);
    }



    public void inOrderTraversalMod(int n){

        inOrderTraversalHelperMod(root, n);

    }

    private void inOrderTraversalHelperMod(TreeNode t, int n){

        if(t == null){

            return;
        }

        inOrderTraversalHelperMod(t.rightNode, n +4);
        for(int u = 0 ; u < n; u ++){
            System.out.printf(" ");
        }
        System.out.printf("%d %n", t.data);

        inOrderTraversalHelperMod(t.leftNode, n + 4);

    }

}