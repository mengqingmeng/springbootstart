package com.example.demo.concurrency.example.publish;

import com.example.demo.concurrency.annoations.NotRecommend;
import com.example.demo.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanbeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.thisCanbeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
