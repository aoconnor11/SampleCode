

class ObjectList
{ 
 private Object[] list ;
 private int total ;

 
 public ObjectList(int sizeIn)
 {
     list = new Object[sizeIn];
     total = 0;
 }

 
 public boolean add(Object objectIn)
 {
     if(!isFull())
     {
         list [total] = objectIn;
         total++;
         return true;
     }
     else
     {
         return false;
     }
 }

     
 public boolean isEmpty()
 {
     if(total==0)
     {
         return true;
     }
     else
     {
         return false;
     }
 }

 
 public boolean isFull()
 {
     if(total== list.length)
     {
         return true;
     }
     else
     {
         return false;
     }
 }



 public Object getItem(int positionIn)
 {
     if (positionIn <1 || positionIn > total)
     {
        return null;
     }
     else
     {
          return list [positionIn -1];
     }   
 }


 public int getTotal()
 {
     return total;
 }


 public boolean remove(int numberIn)
 {
     if(numberIn >= 1 && numberIn <= total) 
     {   
         for(int i = numberIn-1; i <= total-2; i++)
         {
             list[i] = list[i+1];
         }
         total--; 
         return true;
     }
     else 
     {
         return false;
     }
 }
}

