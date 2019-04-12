package com.fenger.sys.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtils {
    public static List<TreeNode> build(List<TreeNode> nodes, Integer topId) {
        List<TreeNode> treeNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if(node.getpId()==topId){
                treeNodes.add(node);
            }
            for (TreeNode node1 : nodes) {
                if(node.getId()==node1.getpId()){
                    node.getChildren().add(node1);
                }
            }
        }
        return treeNodes;
    }
}
