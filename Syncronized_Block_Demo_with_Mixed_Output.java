
   class disp
   {
       public  void wish(String name)  //passing name of person whome we want to wish with only one thread
       {     
           /* Suppose 1Lakh lines of code */ 
        synchronized(this)             //instead of making the whole fn. synchronized, we declared the req. part only sync. hence, preformance is increased
        {                                     
           for(int i=0;i<3;i++)
           {
               System.out.print("Good Morining : ");
               try 
               {
                   Thread.sleep(2000);
               }
               catch(InterruptedException e){}
               System.out.println(name);
           }
        }
        /* Suppose 1Lakh lines of code */
       }
   }
   class MyThread extends Thread
   {
       disp d;
       String name;
       MyThread(disp d,String name)   //constructor to allocate the name corresponding to the object
       {
           this.d=d;
           this.name=name;
       }
       public void run()
       {
           d.wish(name);
       }
   }
   
   
   class Syncronized_Block_Demo_with_Mixed_Output
   {
       public static void main(String arg[])   //both threads are allocated their own objects so, mjixed output
       {
           disp d1=new disp();
           disp d2=new disp();
           MyThread t1=new MyThread(d1,"Dhoni");
           MyThread t2=new MyThread(d2,"Yuvraj");
           t1.start();
           t2.start(); 
                 
       }
   }