class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort by start time of meetings 
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        // each room is used 0 times in the beginning 
        int roomUsedCount[]=new int[n];
        // each room will be last available at 
        // roomUsedCount[i] means room no. i will be last available at 
        long lastAvailableAt[]=new long[n];
        for(int meet[]:meetings){
            int start=meet[0];
            int end=meet[1];
            int duration=end-start;
            long earlyEndRoomTime=Long.MAX_VALUE;
            int earlyEndRoom=0;
            boolean found=false;
            // find the first available meeting room 
            for(int room=0;room<n;room++){
                if(lastAvailableAt[room]<=start){
                    found=true;
                    lastAvailableAt[room]=end;//current meeting will be finished at end
                    roomUsedCount[room]++;
                    break;
                }
                if(lastAvailableAt[room]<earlyEndRoomTime){
                    earlyEndRoomTime=lastAvailableAt[room];
                    earlyEndRoom=room;
                }
            }

            if(!found){
                lastAvailableAt[earlyEndRoom]+=duration;
                roomUsedCount[earlyEndRoom]++;
            }
        }
        int resultRoom=-1;
        int maxUse=0;
        for(int room=0;room<n;room++){
            if(roomUsedCount[room]>maxUse){
                maxUse=roomUsedCount[room];
                resultRoom=room;
            }
        }
        return resultRoom;
    }
}

//T.C : O(mlogm +m*n) , where n = number of rooms, m =  number of meetings
//S.C : O(n) lastAvailable at array + usedRoomCount array are of size n



class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // sort by starting time of meetings
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Each room is used 0 times in the beginning
        int[] roomsUsedCount = new int[n];

        // To store {earliest room empty time, room No.}
        var usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        // To store rooms that are used
        PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();
        for (int room = 0; room < n; room++) {
            unusedRooms.add(room); // All rooms are unused in the beginning
        }

        for (int[] meet : meetings) {
            int start = meet[0];
            int end = meet[1];

            // First see, by this time, which rooms can be empty now
            // And move them to unusedRooms
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.add(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.add(new long[]{end, room});
                roomsUsedCount[room]++;
            } else { // We don't have any room available now. Pick the earliest end room
                int room = (int) usedRooms.peek()[1];
                long endTime = usedRooms.poll()[0];
                usedRooms.add(new long[]{endTime + (end - start), room});
                roomsUsedCount[room]++;
            }
        }

        int resultRoom = -1;
        int maxUse = 0;
        for (int room = 0; room < n; room++) {
            if (roomsUsedCount[room] > maxUse) {
                maxUse = roomsUsedCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}

//T.C : O(mlogm + m*log(n)) , where Let n = number of rooms, m =  number of meetings
//S.C : O(n)