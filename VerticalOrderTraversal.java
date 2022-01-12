/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(root, 0, 0));
        
        while(!queue.isEmpty()){
            Element elem = queue.poll();
            
            int x = elem.horizontal;
            int y = elem.level;
            TreeNode node = elem.node;
            
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            
            TreeMap<Integer, List<Integer>> tempMap = new TreeMap<>();
            
            if(map.containsKey(x)){
                if(map.get(x).containsKey(y)){
                    map.get(x).get(y).add(node.val);
                }else{
                    map.get(x).put(y, list);
                }
            }else{
                tempMap.put(y, list);
                map.put(x, tempMap);
            }
            
            
            if(node.left != null){
                queue.offer(new Element(node.left, x-1, y+1));
            }
            if(node.right != null){
                queue.offer(new Element(node.right, x+1, y+1));
            }
        }
        
        for(TreeMap<Integer, List<Integer>> value: map.values()){
            res.add(new ArrayList<>());
            for(List<Integer> each: value.values()){
                for(int i = 0; i < each.size(); i++){
                    res.get(res.size()-1).add(each.get(i));
                }
            }
        }
        
        return res;
    }
    
    class Element{
        TreeNode node;
        int horizontal, level;
        Element(TreeNode node, int horizontal, int level){
            this.node = node;
            this.horizontal = horizontal;
            this.level = level;
        }
    }
}
