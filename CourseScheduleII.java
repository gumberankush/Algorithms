class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int[] courses = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            courses[index++] = course;
            
            List<Integer> courseList = list[course];
            
            for(int courseObj: courseList){
                indegree[courseObj]--;
                
                if(indegree[courseObj] == 0){
                    queue.add(courseObj);
                }
            }   
        }
        
        return (index == numCourses) ? courses : new int[0];
    }
}
