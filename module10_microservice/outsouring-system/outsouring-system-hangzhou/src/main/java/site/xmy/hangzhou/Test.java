package site.xmy.hangzhou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    private int p1;
    private int p2;
    private int p3;
    private int p4;

    public static class Builder{
        private final int p1;
        private final int p2;

        private int p3 = 0;
        private int p4 = 0;

        public Builder(int p1,int p2){
            this.p1 = p1;
            this.p2 = p2;
        }

        public Builder p3(int v){
            p3 = v;
            return this;
        }

        public Builder p4(int v){
            p4 = v;
            return this;
        }

        public Test build(){
            return new Test(this);
        }
    }

    private Test(Builder builder){
        p1 = builder.p1;
        p2 = builder.p2;
        p3 = builder.p3;
        p4 = builder.p4;
    }

    public static void main(String[] args) {
        Test t = new Builder(1,2).p3(3).build();
        System.out.println(t);

        List l = new ArrayList();
        l.add("hi");
        System.out.println(l.get(0));
    }
}
