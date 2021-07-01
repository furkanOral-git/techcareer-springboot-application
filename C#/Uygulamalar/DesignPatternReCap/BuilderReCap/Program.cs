using System;

namespace BuilderReCap
{
    class Program
    {
        static void Main(string[] args)
        {
            IArabaBuilder araba = new OpelConcreteArabaBuilder();
            ArabaDirector arabaDirector = new ArabaDirector();
            arabaDirector.ArabaUret(araba);
            Console.WriteLine(araba.Araba.ToString());

            araba = new MercedesConcreteArabaBuilder();
            arabaDirector.ArabaUret(araba);
            Console.WriteLine(araba.Araba.ToString());
            
            
            Console.ReadLine();
        }
    }
    class Araba
    {
        public string Marka { get; set; }
        public string Model { get; set; }
        public double KM { get; set; }
        public bool OtoVites { get; set; }


        public override string ToString()
        {
            return $"{Marka} marka araba, {Model} modelinde, {KM} km , otomatik vites = {OtoVites} olarak üretilmiştir";
        }
    }
    abstract class IArabaBuilder
    {
        protected Araba araba;
        public Araba Araba
        {
            get { return araba; }
        }

        public abstract void SetMarka();
        public abstract void SetModel();
        public abstract void SetKM();
        public abstract void SetOtoVites();


    }
    class OpelConcreteArabaBuilder : IArabaBuilder
    {

        public OpelConcreteArabaBuilder()
        {
            araba = new Araba();
        }

        public override void SetKM() => araba.KM = 100;
        public override void SetMarka() => araba.Marka = "Opel";
        public override void SetModel() => araba.Model = "Astra";
        public override void SetOtoVites() => araba.OtoVites = false;

    }
    class MercedesConcreteArabaBuilder : IArabaBuilder
    {
        public MercedesConcreteArabaBuilder()
        {
            araba = new Araba();
        }

        public override void SetKM() => araba.KM = 200;
        public override void SetMarka() => araba.Marka = "Mercedes";
        public override void SetModel() => araba.Model = "Benz";
        public override void SetOtoVites() => araba.OtoVites = true;

    }
    class ArabaDirector
    {
        public void ArabaUret(IArabaBuilder araba)
        {
            araba.SetKM();
            araba.SetMarka();
            araba.SetModel();
            araba.SetOtoVites();
            
        }
    }

}
