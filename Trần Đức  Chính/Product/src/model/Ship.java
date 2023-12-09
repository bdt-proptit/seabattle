package model;

public class Ship {
    private String name;
    private int length;
    private String head;
    private String tail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public boolean checkLength(String head, String last){
        int headXIndex = head.toUpperCase().charAt(0) - 'A';
        int lastXIndex = last.toUpperCase().charAt(0) - 'A';
        int headYIndex = Integer.parseInt(head.substring(1)) - 1;
        int lastYIndex = Integer.parseInt(last.substring(1)) - 1;
        int inputLength = 0;
        if (headXIndex == lastXIndex) {
            inputLength = lastYIndex - headYIndex + 1;
        } else if (headYIndex == lastYIndex) {
            inputLength = lastXIndex - headXIndex + 1;
        }
        return this.getLength() == inputLength;
    }
}
