using System;

namespace BridgeReCap
{
    class Program
    {
        static void Main(string[] args)
        {
            CustomerManager customerManager = new CustomerManager();
            customerManager.MessageSender = new SmsSender(new Body {Title="About the UserName" });
            customerManager.UpdateCustomer();
            Console.ReadLine();
        }
    }
    public class Body
    {
        public string Title { get; set; }
        public string Text { get; set; }
    }
    public abstract class MessageSenderBase
    {
        public void Save()
        {
            Console.WriteLine("Message Saved");
        }
        public abstract void Send(Body body);
    }
    public class SmsSender : MessageSenderBase
    {
        Body _body;
        public SmsSender(Body body)
        {
           _body = body;
        }
        public override void Send(Body body)
        {
            body = _body;
            Console.WriteLine("{0} was sent via SMSSender",body.Title);
        }
    }
    public class EmailSender : MessageSenderBase
    {
        public override void Send(Body body)
        {
            Console.WriteLine("{0} was sent via EmailSender",body.Title);
        }
    }
    public class CustomerManager
    {
        public MessageSenderBase MessageSender { get; set; }

        public void UpdateCustomer()
        {
            MessageSender.Send(new Body());
            Console.WriteLine("Customer Updated");
        }
    }
}
