public class LowestCommonAncestor {

    public TreeNode node;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.getVal() == p.getVal() || root.getVal() == q.getVal())
        return root;

        TreeNode leftLCA = lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.getRight(), p, q);

        if(leftLCA!= null && rightLCA != null){
            return root;
        }

        return (leftLCA != null ? leftLCA : rightLCA);
    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.getVal() == p.getVal() || root.getVal() == q.getVal())
            return root;

        TreeNode leftLCA = lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.getRight(), p, q);

        if(leftLCA!= null && rightLCA != null){
            return root;
        }

        return (leftLCA != null ? leftLCA : rightLCA);
    }



    public static void main(String[] args) {

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.setLeft(left);

        TreeNode left1 = new TreeNode(4);
        left.setLeft(left1);

        TreeNode right1 = new TreeNode(5);
        left.setRight(right1);

        TreeNode right = new TreeNode(3);
        root.setRight(right);

        right.setLeft(new TreeNode(6));
        right.setRight(new TreeNode(7));
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, new TreeNode(7), new TreeNode(5)));

    }
}
