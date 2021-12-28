/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
class ItemDetails{
    int value, weight;
    double fraction;
    ItemDetails(int x, int y, double z){
        this.value = x;
        this.weight = y;
        this.fraction = z;
    }
}

class FractionalKnapsack
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        List<ItemDetails> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            list.add(new ItemDetails(arr[i].value, arr[i].weight, (double)arr[i].value/(double)arr[i].weight));
        }
        
        Collections.sort(list, (a, b) -> Double.compare(b.fraction, a.fraction));
        
        int weight = 0;
        double value = 0.0;
        int remainingWeight = W;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).weight < remainingWeight){
                weight += list.get(i).weight;
                value += (double)list.get(i).value;
            }else{
                // int diff = W - weight;
                value += list.get(i).fraction*(double)remainingWeight;
                break;
            }
            remainingWeight = W - weight;
        }
        return value;
    }
    
}
