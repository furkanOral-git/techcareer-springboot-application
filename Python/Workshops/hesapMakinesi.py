
while True :

    sayi1 = int(input("1.Sayınızı Giriniz:"))
    işlem = input("işlem")
    sayi2 = int(input("2.Sayınızı Giriniz:"))

    class MM :
    
        
        def topla (sayi1,sayi2):
            return sayi1 + sayi2
        def carp (sayi1,sayi2):
            return sayi1 * sayi2
        def bol (sayi1,sayi2):
            return sayi1 / sayi2
        def cıkar (sayi1,sayi2):
            return sayi1 - sayi2

    islemler = ["+","-","*","/"]


    while True :
        if işlem in islemler :
            if işlem == "+":
                print(MM.topla(sayi1, sayi2))
                break
            elif işlem == "-":
                print(MM.cıkar(sayi1,sayi2))
                break
            elif işlem == "*":
                print(MM.carp(sayi1, sayi2))
                break
            elif işlem == "/":
               print(MM.bol(sayi1, sayi2)) 
               break    
   
        else:
            print("Herhangi bir işlem belirtmiyor.")
            break








       
                  

    





    
    





