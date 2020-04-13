package com.zy.service;

public class test {
    public static void main(String[] args) {
	dog p = new dog();
		p.run();
		p.eat();
//		System.out.println(d instanceof dog);
    }
    public static class pet{
        public void run() {
            System.out.println("pet跑跑跑");
        }
        public void eat() {
            System.out.println("吃是一种病");
        }
    }

    public static class dog extends pet{

        public void  run() {
            super.run();
            run();
        }
        public void bark() {
            System.out.println("汪汪汪");
        }
        public void eat() {
            System.out.println("吃吃吃");
        }
    }
}
