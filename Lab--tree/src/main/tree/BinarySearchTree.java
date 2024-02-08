package tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    // Método para buscar um elemento na árvore
    public boolean buscaElemento(int valor) {
        return buscaElemento(root, valor);
    }

    private boolean buscaElemento(Node node, int valor) {
        if (node == null)
            return false;

        if (valor == node.data)
            return true;
        else if (valor < node.data)
            return buscaElemento(node.left, valor);
        else
            return buscaElemento(node.right, valor);
    }

    // Método para encontrar o valor mínimo na árvore
    public int minimo() {
        if (root == null)
            throw new IllegalStateException("Árvore vazia");
        return minimo(root).data;
    }

    private Node minimo(Node node) {
        if (node.left == null)
            return node;
        return minimo(node.left);
    }

    // Método para encontrar o valor máximo na árvore
    public int maximo() {
        if (root == null)
            throw new IllegalStateException("Árvore vazia");
        return maximo(root).data;
    }

    private Node maximo(Node node) {
        if (node.right == null)
            return node;
        return maximo(node.right);
    }

    // Método para inserir um elemento na árvore
    public void insereElemento(int valor) {
        root = insereElemento(root, valor);
    }

    private Node insereElemento(Node node, int valor) {
        if (node == null)
            return new Node(valor);

        if (valor < node.data)
            node.left = insereElemento(node.left, valor);
        else if (valor > node.data)
            node.right = insereElemento(node.right, valor);

        return node;
    }

    // Método para remover um elemento da árvore
    public void remove(int valor) {
        root = remove(root, valor);
    }

    private Node remove(Node node, int valor) {
        if (node == null)
            return null;

        if (valor < node.data)
            node.left = remove(node.left, valor);
        else if (valor > node.data)
            node.right = remove(node.right, valor);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            node.data = minimo(node.right).data;
            node.right = remove(node.right, node.data);
        }
        return node;
    }

    // Método para retornar a travessia em pré-ordem da árvore
    public int[] preOrdem() {
        List<Integer> lista = new ArrayList<>();
        preOrdem(root, lista);
        return lista.stream().mapToInt(i -> i).toArray();
    }

    private void preOrdem(Node node, List<Integer> lista) {
        if (node != null) {
            lista.add(node.data);
            preOrdem(node.left, lista);
            preOrdem(node.right, lista);
        }
    }

    // Método para retornar a travessia em ordem da árvore
    public int[] emOrdem() {
        List<Integer> lista = new ArrayList<>();
        emOrdem(root, lista);
        return lista.stream().mapToInt(i -> i).toArray();
    }

    private void emOrdem(Node node, List<Integer> lista) {
        if (node != null) {
            emOrdem(node.left, lista);
            lista.add(node.data);
            emOrdem(node.right, lista);
        }
    }

    // Método para retornar a travessia em pós-ordem da árvore
    public int[] posOrdem() {
        List<Integer> lista = new ArrayList<>();
        posOrdem(root, lista);
        return lista.stream().mapToInt(i -> i).toArray();
    }

    private void posOrdem(Node node, List<Integer> lista) {
        if (node != null) {
            posOrdem(node.left, lista);
            posOrdem(node.right, lista);
            lista.add(node.data);
        }
    }
}