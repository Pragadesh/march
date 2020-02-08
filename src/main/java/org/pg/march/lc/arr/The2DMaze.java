package org.pg.march.lc.arr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/the-maze-ii/
 * https://leetcode.com/problems/the-maze-iii/
 */
public class The2DMaze {

	
	class Point implements Comparable<Point> {
        int x,y,l;
        String s;
        public Point(int _x, int _y) {x=_x;y=_y;l=Integer.MAX_VALUE;s="";}
        public Point(int _x, int _y, int _l,String _s) {x=_x;y=_y;l=_l;s=_s;}
        public int compareTo(Point p) {return l==p.l?s.compareTo(p.s):l-p.l;}
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m=maze.length, n=maze[0].length;
        Point[][] points=new Point[m][n];
        for (int i=0;i<m*n;i++) points[i/n][i%n]=new Point(i/n, i%n);
        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        String[] ds=new String[] {"u","r","d","l"};
        PriorityQueue<Point> list=new PriorityQueue<>(); // using priority queue
        list.offer(new Point(ball[0], ball[1], 0, ""));
        while (!list.isEmpty()) {
            Point p=list.poll();
            if (points[p.x][p.y].compareTo(p)<=0) continue; // if we have already found a route shorter
            points[p.x][p.y]=p;
            for (int i=0;i<4;i++) {
                int xx=p.x, yy=p.y, l=p.l;
                while (xx>=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]==0 && (xx!=hole[0] || yy!=hole[1])) {
                    xx+=dir[i][0];
                    yy+=dir[i][1];
                    l++;
                }
                if (xx!=hole[0] || yy!=hole[1]) { // check the hole
                    xx-=dir[i][0];
                    yy-=dir[i][1];
                    l--;
                }
                list.offer(new Point(xx, yy, l, p.s+ds[i]));
            }
        }
        return points[hole[0]][hole[1]].l==Integer.MAX_VALUE?"impossible":points[hole[0]][hole[1]].s;
    }
	
	
	
	private final int[][] directions = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	private int R;
	private int C;
	
	public String findShortestWayFirstTry(int[][] maze, int[] ballOriginal, int[] hole) {
		R = maze.length;
		C = maze.length;
		int[] distance = new int[R * C];
		int[] edgeFrom = new int[R * C];
		Arrays.fill(distance, -1);
		Arrays.fill(edgeFrom, -1);
		Queue<int[]> queue = new LinkedList<>();
		distance[to1D(ballOriginal)] = 0;
		edgeFrom[to1D(ballOriginal)] = to1D(ballOriginal);
		queue.offer(ballOriginal);
		while (!queue.isEmpty()) {
			int[] ball = queue.poll();
			for (int i = 0; i < directions.length; i++) {
				int x = ball[0];
				int y = ball[1];
				int[] dir = directions[i];
				int dist = distance[to1D(ball)];
				while(x + dir[0] >=0 && x + dir[0] < R && y + dir[1] >=0 && y + dir[1] < C && maze[x + dir[0]][y + dir[1]] == 0) {
					x += dir[0];
					y += dir[1];
					dist++;
					int index1D = x * C + y;
					if(x == hole[0] && y == hole[1] && (distance[index1D] == -1 || distance[index1D] > dist)) {
						distance[index1D] = dist;
						edgeFrom[index1D] = to1D(ball);
					}
				}
				int index1D = x * C + y;
				if(distance[index1D] == -1 || distance[index1D] > dist) {
					queue.offer(new int[] {x,y});
					distance[index1D] = dist;
					edgeFrom[index1D] = to1D(ball);
				}
			}
		}
		
		if (distance[to1D(hole)] == -1)
			return "impossible";
		StringBuilder builder = new StringBuilder();
		int next = to1D(hole);
		int curr = edgeFrom[next];
		while(curr != next) {
			builder.append(findDirection(curr, next));
			next = curr;
			curr = edgeFrom[curr];
		}
		return builder.reverse().toString();
	}
	
	private int to1D(int[] ball) {
		return ball[0] * C + ball[1];
	}
	
	private char findDirection(int start, int end) {
		int startX = start / C;
		int startY = start % C;
		int endX = end / C;
		int endY = end % C;
		if(startX < endX) {
			return 'd';
		}else if (startX > endX) {
			return 'u';
		}else if(startY < endY) {
			return 'r';
		}else {
			return 'l';
		}
	}
	
	
	
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		int R = maze.length;
		int C = maze[0].length;
		int[][] distance = new int[R][C];
		for(int i = 0; i<R; i++) {
			Arrays.fill(distance[i], -1);
		}
		Queue<int[]> queue = new LinkedList<>();
		distance[start[0]][start[1]] = 0;
		queue.offer(start);
		while (!queue.isEmpty()) {
			int[] ball = queue.poll();
			for (int i = 0; i < directions.length; i++) {
				int x = ball[0];
				int y = ball[1];
				int[] dir = directions[i];
				int dist = distance[x][y];
				while(x + dir[0] >=0 && x + dir[0] < R && y + dir[1] >=0 && y + dir[1] < C && maze[x + dir[0]][y + dir[1]] == 0) {
					x += dir[0];
					y += dir[1];
					dist++;
				}
				if(distance[x][y] == -1 || distance[x][y] > dist) {
					queue.offer(new int[] {x,y});
					distance[x][y] = dist;
				}
			}
			
		}
		return distance[destination[0]][destination[1]];
	}
}
