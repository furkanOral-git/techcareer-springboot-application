
sayi = int(input("Sayınızı Giriniz =  " ))

faktoriyel = 1

if sayi<0 :
    print("negatif sayı girdiniz!!")
elif sayi==0 :
    print("Sonuç = 1")
else :   
    for x in range (1,sayi + 1):
            faktoriyel = faktoriyel* x
           
    print("Sonuç = " , faktoriyel)        
    









