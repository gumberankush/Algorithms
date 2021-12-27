class Meeting{
    int start;
    int end;
    
    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class NMeetings 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Meeting> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            list.add(new Meeting(start[i], end[i]));
        }
        
        Collections.sort(list, (a, b) -> Integer.compare(a.end, b.end));
        
        int count = 1;
        
        int meetingStart = list.get(0).start;
        int meetingEnd = list.get(0).end;
        for(int i = 1; i < n; i++){
            if(list.get(i).start > meetingEnd){
                meetingEnd = list.get(i).end;
                count++;
            }
        }
        return count;
    }
