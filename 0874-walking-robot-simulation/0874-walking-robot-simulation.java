

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        Set<String> set = new HashSet<>();

        for(int[] ob : obstacles){
            set.add(ob[0] + "," + ob[1]);
        }

        int x = 0;
        int y = 0;

        int dir = 0; 
        // 0 = north
        // 1 = east
        // 2 = south
        // 3 = west

        int[][] directions = {
            {0,1},   // north
            {1,0},   // east
            {0,-1},  // south
            {-1,0}   // west
        };

        int maxDist = 0;

        for(int command : commands){

            if(command == -1){
                dir = (dir + 1) % 4;   // turn right
            }
            else if(command == -2){
                dir = (dir + 3) % 4;   // turn left
            }
            else{

                for(int i = 0; i < command; i++){

                    int nx = x + directions[dir][0];
                    int ny = y + directions[dir][1];

                    if(set.contains(nx + "," + ny)){
                        break;
                    }

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}