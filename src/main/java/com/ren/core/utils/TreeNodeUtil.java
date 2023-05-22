package com.ren.core.utils;


import com.ren.core.base.BaseTreeNodeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 字典树工具类
 * </p>
 *
 * @author R
 */
public class TreeNodeUtil {
    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @return
     */
    public static <T extends BaseTreeNodeEntity<T>> List<T> build(List<T> treeNodes, Object root) {

        List<T> trees = new ArrayList<>();

        for (T treeNode : treeNodes) {

            if (root.equals(treeNode.getParentId())) {
                // 找到父节点为root的节点
                trees.add(treeNode);
            }

            // 找出所有节点的子节点
            for (T it : treeNodes) {
                // 找出 treeNode 的子节点
                if (treeNode.getId().equals(it.getParentId())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<T>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public static <T extends BaseTreeNodeEntity<T>> List<T> buildByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static <T extends BaseTreeNodeEntity<T>> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId().equals(it.getParentId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<T>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static <T extends BaseTreeNodeEntity<T>> T findChildrenList(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId().equals(it.getParentId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<T>());
                }
                treeNode.add(findChildren(it, treeNodes));
            } else {
                findChildrenList(it, treeNodes);
            }
        }
        return treeNode;
    }

}