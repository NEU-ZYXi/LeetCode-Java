
/*

Suppose you are given the following code:
class ZeroEvenOdd {
  public ZeroEvenOdd(int n) { ... }      // constructor
  public void zero(printNumber) { ... }  // only output 0's
  public void even(printNumber) { ... }  // only output even numbers
  public void odd(printNumber) { ... }   // only output odd numbers
}
The same instance of ZeroEvenOdd will be passed to three different threads:
Thread A will call zero() which should only output 0's.
Thread B will call even() which should only ouput even numbers.
Thread C will call odd() which should only output odd numbers.
Each of the thread is given a printNumber method to output an integer.
Modify the given program to output the series 010203040506... where the length of the series must be 2n.

Example 1:
Input: n = 2
Output: "0102"
Explanation: There are three threads being fired asynchronously. 
One of them calls zero(), the other calls even(), and the last one calls odd(). 
"0102" is the correct output.

Example 2:
Input: n = 5
Output: "0102030405"

*/

/*

Solution: semaphore for zero, odd and even
          zero acquire then release either odd or even, odd or even acquire then release zero         

*/

import java.util.concurrent.*;

class ZeroEvenOdd {
    private int n;
    private Semaphore zero;
    private Semaphore odd;
    private Semaphore even;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zero = new Semaphore(1);
        this.odd = new Semaphore(0);
        this.even = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        int n = this.n;
        for (int i = 0; i < n; ++i) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int n = this.n / 2, cur = 2;
        for (int i = 0; i < n; ++i) {
            even.acquire();
            printNumber.accept(cur);
            cur += 2;
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int n = this.n % 2 == 0 ? this.n / 2 : this.n / 2 + 1, cur = 1;
        for (int i = 0; i < n; ++i) {
            odd.acquire();
            printNumber.accept(cur);
            cur += 2;
            zero.release();
        }
    }
}



