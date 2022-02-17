class Recipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> suppliesSet = new HashSet<>();
        
        List<String> res = new ArrayList<>();
        
        List<String> recipesList = new ArrayList<>();
        for(String recipe: recipes){
            recipesList.add(recipe);
        }
        
        Map<String, List<String>> graph = new HashMap<>();
    
        Map<String, Integer> indegreeMap = new HashMap<>();
        
        Queue<String> queue = new LinkedList<>();
        
        for(int i = 0; i < ingredients.size(); i++){
            List<String> ingredient = ingredients.get(i);
            
            for(int j = 0; j < ingredient.size(); j++){
                String ingredientItem = ingredient.get(j);
                // creating graph nodes only if it is contained in supplies
                if(graph.containsKey(ingredientItem)){
                    List<String> itemList = graph.get(ingredientItem);
                    itemList.add(recipes[i]);
                    graph.put(ingredientItem, itemList);
                }else{
                    List<String> list = new ArrayList<>();
                    list.add(recipes[i]);
                    graph.put(ingredientItem, list);
                }


                // create indegree map
                indegreeMap.put(recipes[i], indegreeMap.getOrDefault(recipes[i], 0)+1);
                
            }
        }
        
        // put supplies into queue as they have indegree as 0. No dependency
        for(String supply: supplies){
            queue.add(supply);
        }
        
        while(!queue.isEmpty()){
            String item = queue.poll();
            
            // check if the extracted item is in recipes
            if(recipesList.contains(item)){
                res.add(item);
            }
            
            if(graph.get(item) != null && graph.get(item).size() > 0){
            
                for(String obj: graph.get(item)){
                    indegreeMap.put(obj, indegreeMap.get(obj)-1);

                    if(indegreeMap.get(obj) == 0){
                        queue.add(obj);
                    }
                }
            }
        }
        
        return res;
    }
}
