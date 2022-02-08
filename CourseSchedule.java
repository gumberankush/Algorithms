class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] list = new LinkedList[numCourses];
        
        for(int i = 0; i < list.length; i++){
            list[i] = new LinkedList<>();
        }
        
        int[] indegree = new int[numCourses];
        
        for(int[] prereq: prerequisites){
            indegree[prereq[0]]++;
            list[prereq[1]].add(prereq[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                count++;
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            
            List<Integer> courseList = list[course];
            
            for(int courseObj: courseList){
                indegree[courseObj]--;
                
                if(indegree[courseObj] == 0){
                    count++;
                    queue.add(courseObj);
                }
            }
        }
        
        if(count == numCourses)
            return true;
        
        return false;
    }
}  
