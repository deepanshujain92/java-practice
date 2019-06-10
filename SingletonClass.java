/*SingletonClass : When the singleton class is loaded, inner class is not loaded and hence doesn’t create object 
when loading the class. Inner class is created only when getInstance() method is called. 
So it may seem like eager initialization but it is lazy initialization.*/
public class SingletonClass  
{ 
  
  private SingletonClass()  
  { 
    // private constructor : created to prevention of object getting created
  } 
  
  // Inner class to provide instance of class 
  private static class InnerClassSingleton 
  { 
    // It will be created when getInstance Method call it, it's lazy initialization.
    private static final SingletonClass INSTANCE = new SingletonClass(); 
  } 
  
  public static SingletonClass getInstance()  
  { 
    return InnerClassSingleton.INSTANCE; 
  } 
} 
