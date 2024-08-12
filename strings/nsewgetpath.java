package strings;
// Given a route containing 4 directions (E,W,N,S)
// find the shortest path to each destinations
// using formula math.sqrt((x2-x1)^2+(y2-y1)^2)
// --> for north - y+1
//         south - y-1
//         east  - x+1
//         west  -  x-1
public class nsewgetpath {
    public static void main(String[] args) {
        String path="WNEENESENNN";
        // String path = "NS";
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir = path.charAt(i);
            //south
            if(dir=='S'){
                y--;
            } 
            //north
            else if(dir=='N'){
                y++;
            }
            //east
            else if(dir == 'E'){
                x++;
            }
            //west
            else{
                x--;
            }
        }
        int x2=x*x;
        int y2=y*y;
        float ans = (float)Math.sqrt(x2+y2);
        System.out.println(ans);
    }
}
