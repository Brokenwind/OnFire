package com.broken.cate.leet.media;

import java.util.ArrayList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // https://blog.csdn.net/fuxuemingzhu/article/details/82951771
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());

        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(prerequisite).add(course);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i)
            if (dfs(i, graph, visited)) return false;

        return true;
    }

    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        // accessing, 有环
        if (visited[curr] == 1) return true;
        // accessed, and no circle
        if (visited[curr] == 2) return false;
        // 标记正在访问
        visited[curr] = 1;

        for (int next : graph.get(curr)) {
            if (dfs(next, graph, visited)) return true;
        }
        // 从当前节点开始没有环
        visited[curr] = 2;
        return false;
    }
}
