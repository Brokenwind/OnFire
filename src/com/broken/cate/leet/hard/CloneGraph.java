package com.broken.cate.leet.hard;

import com.broken.cate.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
    // https://www.cnblogs.com/springfor/p/3874591.html
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        // 旧节点和新节点的对应，判断原节点是否已经被访问
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                // 节点还没有被访问
                if (!hm.containsKey(neighbor)) {
                    queue.add(neighbor);
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    hm.put(neighbor, newNode);
                }
                hm.get(curNode).neighbors.add(hm.get(neighbor));
            }
        }
        return head;
    }
}
