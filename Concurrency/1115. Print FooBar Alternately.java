
/*

Suppose you are given the following code:
class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }
  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads. 
Thread A will call foo() while thread B will call bar(). 
Modify the given program to output "foobar" n times.

Example 1:
Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. 
One of them calls foo(), while the other calls bar(). 
"foobar" is being output 1 time.

Example 2:
Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.

*/

/*

Solution: use semaphore to control the number of threads, acquire foo to print 'foo' then release bar
          acquire bar to print 'bar' then release foo because we cannot acquire the same semaphore before releasing          

*/

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	  // printFoo.run() outputs "foo". Do not change or remove this line.
            foo.acquire();
        	  printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            bar.acquire();
        	  printBar.run();
            foo.release();
        }
    }
}



