using System;

namespace InterpreterReCap
{
    class Program
    {
        static void Main(string[] args)
        {
            //context,Abstract Expression,NonTerminal Expression, Terminal Expression

        }
    }
    class Context
    {
        public string _input;
        public int _output;
        public string _İnput { get { return _input; }  }
        public int _Output { get { return _output; }  }
        
        public Context(string input)
        {
           this._input = input;
        }
        
    }
    abstract class Expression
    {
        public void Interpret(Context context)
        {
            if (context._input == "X")
            {
                context._output 
            }
        }
    }


}
