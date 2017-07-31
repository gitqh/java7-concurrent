package org.gitqh.ConditionLock;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-18:00
 */
public class FileMock {
    private String[] content;
    private int index;

    public FileMock(int size, int length) {
        content=new String[size];
        for (int i=0;i<size;i++){
            StringBuilder builder = new StringBuilder(length);
            for (int j=0;j<length;j++){
                int indice = (int) (Math.random()*255);
                builder.append(indice);
            }
            content[i] = builder.toString();
        }
        index = 0;
    }

    public boolean hasMoreLines(){
        return index<content.length;
    }

    public String getLine() {
        if (this.hasMoreLines()){
            System.out.println("mock: " + (content.length - index));
            return content[index++];
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        FileMock test = new FileMock(10,5);
        System.out.println(test.toString());
    }
}
