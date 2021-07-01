using System;

namespace PrototypeReCap
{
    class Program
    {
        static void Main(string[] args)
        {
            ColorManager colorManager = new ColorManager();
            colorManager.Operation(new Black());
            colorManager.Operation(new White());
            Console.ReadLine();
        }
    }
    //Prototype
    public interface  IColor
    {
        public void Clone();
    }
    //Concrete Prototpe
    public class Black : IColor
    {
        public void Clone()
        {
            Console.WriteLine("Siyah");
        }
    }
    //Concrete Prototype
    public class White : IColor
    {
        public void Clone()
        {
            Console.WriteLine("Beyaz");
        }
    }
    public class ColorManager
    {

        public void Operation(IColor color)
        {
            color.Clone();
        }
        
    }
}
