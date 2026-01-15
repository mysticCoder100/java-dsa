package com.github.mysticcoder100.binarytree;

public class Tree {
    private Node root;

    public Node find(long userId) {
        Node current = root;

        while(current.data.getUserId() != userId) {
            if (current.data.getUserId() > userId ) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(Person data) {
        Node newNode = new Node(data);
        if (root == null){
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (current.data.getUserId() > data.userId() ) {
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }

        }
    }

    public Node delete(long userId) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.data.getUserId() != userId) {
            parent = current;

            if (userId > current.data.getUserId()) {
                isLeftChild = false;
                current = current.rightChild;
            }else {
                isLeftChild = true;
                current = current.leftChild;
            }

            if (current == null) {
                return null;
            }
        }


        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
        }else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            }else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            }else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else{
                parent.rightChild = successor;
                successor.leftChild = current.leftChild;
            }
        }

        return current;
    }


    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    public void display() {
        inOrder(root);
    }

    private void inOrder(Node root){
        if (root != null) {
            inOrder(root.leftChild);
            System.out.println( root.data.toString());
            inOrder(root.rightChild);
        }
    }
}
