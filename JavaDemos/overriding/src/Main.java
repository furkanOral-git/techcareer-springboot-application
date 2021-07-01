public class Main {

    public static void main(String[] args) {
	BaseKrediManager [] KrediManagers = new BaseKrediManager[]
            {new OgretmenKrediManager(),new TarımKrediManager(),new OgrenciKrediManager() };
	for (BaseKrediManager krediManager:KrediManagers){
    System.out.println(krediManager.hesapla(1000));
    }

    }
}
