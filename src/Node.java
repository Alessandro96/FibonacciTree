public class Node<T>{
    private Node<T> rSon, lSon, parent;
    private T data;
    private Boolean isVisited;

    public Node(Node<T> rSon, Node<T> lSon, Node<T> parent, T data) {
        this.rSon = rSon;
        this.lSon = lSon;
        this.parent = parent;
        this.data = data;
        this.isVisited = false;
    }

    public Node(){}

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getRSon() {
        return rSon;
    }
    public void setRSon(Node<T> rSon) {
        this.rSon = rSon;
    }
    public Node<T> getLSon() {
        return lSon;
    }
    public void setLSon(Node<T> lSon) {
        this.lSon = lSon;
    }

    public Boolean getVisited() {
        return isVisited;
    }

    public void setVisited(Boolean visited) {
        isVisited = visited;
    }

    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
}
